import java.util.Random;

public class StudentManagement {
    private StackStudent studentStack; // Stack gốc chứa sinh viên
    private StackStudent sortedStack;  // Stack phụ chứa sinh viên đã sắp xếp

    // Constructor
    public StudentManagement(int capacity) {
        studentStack = new StackStudent(capacity);
        sortedStack = new StackStudent(capacity);
    }

    // Thêm sinh viên
    public void addStudent(Student student) {
        studentStack.push(student);
        sortedStack.push(student); // Đẩy vào stack phụ để giữ dữ liệu giống nhau
    }

    // Thêm số lượng sinh viên ngẫu nhiên
    public void addRandomStudents(int numberOfStudents) {
        Random random = new Random();
        String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank", "Ivy", "Jack"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"};

        for (int i = 0; i < numberOfStudents; i++) {
            String name = firstNames[random.nextInt(firstNames.length)] + " " + lastNames[random.nextInt(lastNames.length)];
            int id = 1000 + i;
            double score = Math.round((random.nextDouble() * 10) * 100.0) / 100.0;

            addStudent(new Student(name, id, score));
        }

        System.out.println("\nĐã thêm " + numberOfStudents + " sinh viên ngẫu nhiên vào hệ thống.");
    }

    // Xóa sinh viên theo ID
    public boolean deleteStudent(int id) {
        boolean isDeleted = false;
        StackStudent tempStack = new StackStudent(studentStack.capacity);

        // Dùng Stack tạm thời để tìm và xóa sinh viên theo ID
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                isDeleted = true;
            } else {
                tempStack.push(student);
            }
        }

        // Push lại các sinh viên vào stack gốc
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        // Cập nhật stack phụ sau khi xóa
        updateSortedStack();

        return isDeleted;
    }

    // Cập nhật thông tin sinh viên theo ID
    public boolean updateStudent(int id, String newName, double newScore) {
        boolean isUpdated = false;
        StackStudent tempStack = new StackStudent(studentStack.capacity);

        // Dùng Stack tạm thời để tìm và cập nhật sinh viên theo ID
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                student.setName(newName);
                student.setScore(newScore);
                isUpdated = true;
            }
            tempStack.push(student);
        }

        // Push lại các sinh viên vào stack gốc
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        // Cập nhật stack phụ sau khi cập nhật
        updateSortedStack();

        return isUpdated;
    }

    // Tìm kiếm sinh viên theo ID
    public Student findStudentById(int id) {
        Student foundStudent = null;
        StackStudent tempStack = new StackStudent(studentStack.capacity);

        // Dùng Stack tạm thời để tìm sinh viên theo ID
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                foundStudent = student;
            }
            tempStack.push(student);
        }

        // Push lại các sinh viên vào stack gốc
        while (!tempStack.isEmpty()) {
            studentStack.push(tempStack.pop());
        }

        return foundStudent;
    }

    // Cập nhật stack phụ sau mỗi lần thay đổi trên stack gốc
    private void updateSortedStack() {
        sortedStack.clear(); // Xóa dữ liệu cũ trong stack phụ
        StackStudent tempStack = new StackStudent(studentStack.capacity);

        // Sao chép tất cả sinh viên từ stack gốc sang stack phụ
        while (!studentStack.isEmpty()) {
            tempStack.push(studentStack.pop());
        }

        // Đẩy lại vào stack gốc và stack phụ
        while (!tempStack.isEmpty()) {
            Student student = tempStack.pop();
            studentStack.push(student);
            sortedStack.push(student);
        }
    }

    // Sắp xếp sinh viên theo điểm mà không thay đổi stack gốc trong quá trình sắp xếp
    public void sortStudentsByScore(boolean useMergeSort) {
        // Thực hiện sắp xếp trên stack phụ (sortedStack)
        if (useMergeSort) {
            mergeSort(sortedStack, 0, sortedStack.size() - 1);
        } else {
            bubbleSort(sortedStack);
        }
    }

    // Bubble Sort để sắp xếp sinh viên trong stack
    private void bubbleSort(StackStudent stack) {
        int size = stack.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                Student current = stack.get(j);
                Student next = stack.get(j + 1);
                if (current.getScore() > next.getScore()) {
                    stack.swap(j, j + 1);
                }
            }
        }
    }

    // Merge Sort để sắp xếp sinh viên trong stack
    private void mergeSort(StackStudent stack, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(stack, left, mid);
        mergeSort(stack, mid + 1, right);
        merge(stack, left, mid, right);
    }

    private void merge(StackStudent stack, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        StackStudent leftStack = new StackStudent(n1);
        StackStudent rightStack = new StackStudent(n2);

        for (int i = 0; i < n1; i++) {
            leftStack.push(stack.get(left + i));
        }
        for (int j = 0; j < n2; j++) {
            rightStack.push(stack.get(mid + 1 + j));
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftStack.get(i).getScore() <= rightStack.get(j).getScore()) {
                stack.swap(k++, i++);
            } else {
                stack.swap(k++, j++);
            }
        }

        while (i < n1) {
            stack.swap(k++, i++);
        }
        while (j < n2) {
            stack.swap(k++, j++);
        }
    }

    // In danh sách sinh viên
    public void printAllStudents() {
        StackStudent tempStack = new StackStudent(studentStack.capacity);

        // Chuyển tất cả sinh viên từ stack gốc vào stack tạm để in ra
        while (!studentStack.isEmpty()) {
            tempStack.push(studentStack.pop());
        }

        System.out.printf("%-10s %-20s %-10s %-15s\n", "ID", "Name", "Score", "Ranking");
        System.out.println("--------------------------------------------------------------");

        while (!tempStack.isEmpty()) {
            Student student = tempStack.pop();
            System.out.printf("%-10d %-20s %-10.2f %-15s\n",
                    student.getId(),
                    student.getName(),
                    student.getScore(),
                    student.getRanking());
            studentStack.push(student); // Push lại vào stack gốc
        }
    }
}
