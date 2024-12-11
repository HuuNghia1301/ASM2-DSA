import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement(1000);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add student");
            System.out.println("2. Delete student");
            System.out.println("3. Update student");
            System.out.println("4. Search for student");
            System.out.println("5. Sort students by score");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    // Add student manually
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter score: ");
                    double score = scanner.nextDouble();
                    sm.addStudent(new Student(name, id, score));
                    System.out.println("Student added.");
                    sm.printAllStudents();
                    break;

                case 2:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (sm.deleteStudent(deleteId)) {
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student with that ID not found.");
                    }
                    sm.printAllStudents();
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    double newScore = scanner.nextDouble();
                    if (sm.updateStudent(updateId, newName, newScore)) {
                        System.out.println("Student information updated.");
                    } else {
                        System.out.println("Student with that ID not found.");
                    }
                    sm.printAllStudents();
                    break;

                case 4:
                    System.out.print("Enter student ID to search: ");
                    int findId = scanner.nextInt();
                    Student foundStudent = sm.findStudentById(findId);
                    if (foundStudent != null) {
                        System.out.println("Student information: " + foundStudent);
                    } else {
                        System.out.println("Student with that ID not found.");
                    }
                    sm.printAllStudents();
                    break;

                    case 5:
                    // Thêm sinh viên ngẫu nhiên trước khi sắp xếp
                    System.out.print("Enter number of random students to add: ");
                    int randomNum = scanner.nextInt();
                    sm.addRandomStudents(randomNum);
                    System.out.println("Added " + randomNum + " random students.");
                
                    // Sắp xếp sinh viên theo điểm
                    long startTime, endTime;
                
                    // Merge Sort
                    startTime = System.nanoTime();
                    sm.sortStudentsByScore(true); // true for Merge Sort
                    endTime = System.nanoTime();
                    double mergeSortTimeInMilliseconds = (endTime - startTime); // Convert to milliseconds
                    System.out.println("Merge Sort execution time: " + String.format("%.2f", mergeSortTimeInMilliseconds) + " nanosecond(s)");
                
                    // Bubble Sort
                    startTime = System.nanoTime();
                    sm.sortStudentsByScore(false); // false for Bubble Sort
                    endTime = System.nanoTime();
                    double bubbleSortTimeInMilliseconds = (endTime - startTime) ; // Convert to milliseconds
                    System.out.println("Bubble Sort execution time: " + String.format("%.2f", bubbleSortTimeInMilliseconds) + " nanosecond(s)");
                
                    break;
                

                case 0:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
