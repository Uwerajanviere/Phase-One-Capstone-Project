import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nUNIVERSITY SYSTEM");
            System.out.println("1. Register Student");
            System.out.println("2. Create Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. View Dean's List");
            System.out.println("5. see all courses");
            System.out.println("6. Save and Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {
                    System.out.print("Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Department: ");
                    String dept = scanner.nextLine();
                    System.out.print("GPA: ");
                    double gpa = scanner.nextDouble();

                    manager.registerStudent(new Student(id, dept, gpa));
                    System.out.println("Student registered!");
                }

                case 2 -> {
                    System.out.print("Course ID: ");
                    String cid = scanner.nextLine();
                    System.out.print("Course Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Credits: ");
                    int credits = scanner.nextInt();

                    manager.createCourse(cid, name, credits);
                    System.out.println("Course created!");
                }

                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();

                    System.out.print("Enter Course ID: ");
                    String courseId = scanner.nextLine();

                    Student student = manager.findStudentById(studentId);
                    Course course = manager.findCourseById(courseId);

                    if (student == null) {
                        System.out.println("Student not found!");
                        break;
                    }

                    if (course == null) {
                        System.out.println("Course not found!");
                        break;
                    }

                    try {
                        manager.enrollStudentInCourse(course, student);
                        System.out.println("Student enrolled successfully!");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 4 -> manager.printHighPerformingStudents();
                case 5 -> manager.printCourses();

                case 6 -> {
                    manager.saveAll();
                    System.out.println("Data saved. Exiting...");
                    return;
                }

                default -> System.out.println("Invalid option");
            }
        }
    }
}