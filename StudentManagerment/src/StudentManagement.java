import java.util.Random;

public class StudentManagement {
    private StudentStack studentStack;

    // Constructor
    public StudentManagement(int capacity) {
        studentStack = new StudentStack(capacity);
    }

    // Thêm sinh viên
    public void addStudent(Student student) {
        studentStack.push(student);
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
        Student[] temp = new Student[studentStack.capacity];
        int index = 0;
        boolean isDeleted = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                isDeleted = true;
            } else {
                temp[index++] = student;
            }
        }

        for (int i = index - 1; i >= 0; i--) {
            studentStack.push(temp[i]);
        }

        return isDeleted;
    }

    // Cập nhật thông tin sinh viên theo ID
    public boolean updateStudent(int id, String newName, double newScore) {
        Student[] temp = new Student[studentStack.capacity];
        int index = 0;
        boolean isUpdated = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                student.setName(newName);
                student.setScore(newScore);
                isUpdated = true;
            }
            temp[index++] = student;
        }

        for (int i = index - 1; i >= 0; i--) {
            studentStack.push(temp[i]);
        }

        return isUpdated;
    }

    // Tìm kiếm sinh viên theo ID
    public Student findStudentById(int id) {
        Student[] temp = new Student[studentStack.capacity];
        int index = 0;
        Student foundStudent = null;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                foundStudent = student;
            }
            temp[index++] = student;
        }

        for (int i = index - 1; i >= 0; i--) {
            studentStack.push(temp[i]);
        }

        return foundStudent;
    }

    // Sắp xếp sinh viên theo điểm
    public void sortStudentsByScore(boolean useMergeSort) {
        Student[] temp = new Student[studentStack.capacity];
        int index = 0;

        while (!studentStack.isEmpty()) {
            temp[index++] = studentStack.pop();
        }

        if (useMergeSort) {
            mergeSort(temp, 0, index - 1);
        } else {
            for (int i = 0; i < index - 1; i++) {
                for (int j = 0; j < index - i - 1; j++) {
                    if (temp[j].getScore() > temp[j + 1].getScore()) {
                        Student swap = temp[j];
                        temp[j] = temp[j + 1];
                        temp[j + 1] = swap;
                    }
                }
            }
        }

        for (int i = index - 1; i >= 0; i--) {
            studentStack.push(temp[i]);
        }
    }

    private void mergeSort(Student[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(Student[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i].getScore() <= rightArray[j].getScore()) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    // In danh sách sinh viên
    public void printAllStudents() {
        Student[] temp = new Student[studentStack.capacity];
        int index = 0;

        while (!studentStack.isEmpty()) {
            temp[index++] = studentStack.pop();
        }

        System.out.printf("%-10s %-20s %-10s %-15s\n", "ID", "Name", "Score", "Ranking");
        System.out.println("--------------------------------------------------------------");

        for (int i = index - 1; i >= 0; i--) {
            Student student = temp[i];
            System.out.printf("%-10d %-20s %-10.2f %-15s\n",
                    student.getId(),
                    student.getName(),
                    student.getScore(),
                    student.getRanking());
            studentStack.push(student);
        }
    }
}
