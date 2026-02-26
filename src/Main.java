import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        UniversityManager manager = new UniversityManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n...UNIVERSITY SYSTEM ...");
            System.out.println("1. Register Undergraduate");
            System.out.println("2. Register Graduate");
            System.out.println("3. Register Instructor");
            System.out.println("4. Create Undergraduate Course");
            System.out.println("5. Create Graduate Course");
            System.out.println("6. Enroll Undergraduate");
            System.out.println("7. Enroll Graduate");
            System.out.println("8. Print Students");
            System.out.println("9. Print Courses");
            System.out.println("10. Print Instructors");
            System.out.println("11. Top Student");
            System.out.println("12. Department GPA Average");
            System.out.println("13. Save Data");
            System.out.println("14. Search Student Details");
            System.out.println("15. Calculate Tuition");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Department: ");
                        String dept = scanner.nextLine();
                        System.out.print("GPA: ");
                        double gpa = scanner.nextDouble();
                        manager.registerUndergraduate(new UndergraduateStudent(id, dept, gpa));
                        System.out.println("Undergraduate registered!");
                    }
                    case 2 -> {
                        System.out.print("ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Department: ");
                        String dept = scanner.nextLine();
                        System.out.print("GPA: ");
                        double gpa = scanner.nextDouble();
                        System.out.print("Research Fee: ");
                        double fee = scanner.nextDouble();
                        manager.registerGraduate(new GraduateStudent(id, dept, gpa, fee));
                        System.out.println("Graduate registered!");
                    }
                    case 3 -> {
                        System.out.print("Instructor ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Department: ");
                        String dept = scanner.nextLine();
                        System.out.print("Course Name: ");
                        String cname = scanner.nextLine();
                        manager.registerInstructor(new Instructor(id, dept, cname));
                        System.out.println("Instructor registered!");
                    }
                    case 4 -> {
                        System.out.print("Course ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Course Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Credits: ");
                        int credits = scanner.nextInt();
                        manager.createUndergraduateCourse(new Course(id, name, credits));
                        System.out.println("Undergraduate course created!");
                    }
                    case 5 -> {
                        System.out.print("Course ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Course Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Credits: ");
                        int credits = scanner.nextInt();
                        manager.createGraduateCourse(new Course(id, name, credits));
                        System.out.println("Graduate course created!");
                    }
                    case 6 -> {
                        System.out.print("Student ID: ");
                        String sid = scanner.nextLine();
                        System.out.print("Course ID: ");
                        String cid = scanner.nextLine();
                        manager.enrollUndergraduate(sid, cid);
                        System.out.println("Undergraduate enrolled!");
                    }
                    case 7 -> {
                        System.out.print("Student ID: ");
                        String sid = scanner.nextLine();
                        System.out.print("Course ID: ");
                        String cid = scanner.nextLine();
                        manager.enrollGraduate(sid, cid);
                        System.out.println("Graduate enrolled!");
                    }
                    case 8 -> manager.printStudents();
                    case 9 -> manager.printCourses();
                    case 10 -> manager.printInstructors();
                    case 11 -> {
                        Student top = manager.getTopStudent();
                        System.out.println(top == null ? "No students yet" : "Top Student: " + top.getId());
                    }
                    case 12 -> {
                        System.out.print("Department: ");
                        String dept = scanner.nextLine();
                        double avg = manager.calculateAverageGpa(dept);
                        System.out.println("Average GPA: " + avg);
                    }
                    case 13 -> {
                        manager.saveAll();
                        System.out.println("Data saved!");
                    }


                    case 14 -> {
                        System.out.print("Enter Student ID: ");
                        String sid = scanner.nextLine();

                        Student student = null;
                        String type = "";

                        if (manager.undergraduateStudents.containsKey(sid)) {
                            student = manager.undergraduateStudents.get(sid);
                            type = "Undergraduate";
                        } else if (manager.graduateStudents.containsKey(sid)) {
                            student = manager.graduateStudents.get(sid);
                            type = "Graduate";
                        }

                        if (student == null) {
                            System.out.println("Student not found!");
                            break;
                        }

                        System.out.println("\nStudent ID: " + student.getId());
                        System.out.println("Department: " + student.getDepartment());
                        System.out.println("GPA: " + student.getGpa());
                        System.out.println("Type: " + type);

                        System.out.println("\nEnrolled Courses:");

                        if (student.getCoursesAndGrades().isEmpty()) {
                            System.out.println("No courses enrolled yet.");
                        } else {
                            for (Course c : student.getCoursesAndGrades().keySet()) {
                                String instructorName = "N/A";
                                for (Instructor i : manager.instructors.values()) {
                                    if (i.getCourseName().equalsIgnoreCase(c.getCourseName())) {
                                        instructorName = i.getId();
                                        break;
                                    }
                                }
                                System.out.println("Course: " + c.getCourseName() + " | Instructor: " + instructorName);
                            }
                        }
                    }
                    case 15 -> {
                        System.out.print("Student ID: ");
                        String sid = scanner.nextLine();

                        if (manager.undergraduateStudents.containsKey(sid)) {
                            System.out.print("Enter flat rate: ");
                            double flatRate = scanner.nextDouble();
                            double tuition = manager.calculateUndergraduateTuition(sid, flatRate);
                            System.out.println("Undergraduate Tuition: " + tuition);
                        } else if (manager.graduateStudents.containsKey(sid)) {
                            System.out.print("Enter per-credit rate: ");
                            double rate = scanner.nextDouble();
                            double tuition = manager.calculateGraduateTuition(sid, rate);
                            System.out.println("Graduate Tuition: " + tuition);
                        } else {
                            System.out.println("Student not found!");
                        }
                    }

                    case 0 -> {
                        manager.saveAll();
                        System.out.println("Saved & exiting...");
                        return;
                    }

                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}