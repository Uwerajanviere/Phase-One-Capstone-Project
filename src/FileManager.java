import java.io.*;
import java.util.List;

public class FileManager {

    private static final String studentsFile = "students.txt";
    private static final String courseFile = "courses.txt";


    public static void saveStudents(List<Student> students) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(studentsFile))) {
            for (Student s : students) {
                bufferedWriter.write(s.getId() + "," + s.getDepartment() + "," + s.getGpa());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving students");
        }
    }


    public static void loadStudents(List<Student> students) {
        File file = new File(studentsFile);
        if (!file.exists()) {

            System.out.println("file do not exist");
        };

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(
                        data[0],
                        data[1],
                        Double.parseDouble(data[2])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error loading students");
        }
    }


    public static void saveCourses(List<Course> courses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(courseFile))) {
            for (Course c : courses) {
                writer.write(c.getCourseId()+ "," + c.getCourseName() + "," + c.getCredits());
                writer.newLine();

            }

        } catch (IOException e) {
            System.out.println("Error saving courses");
        }
    }


    public static void loadCourses(List<Course> courses) {
        File file = new File(courseFile);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                courses.add(new Course(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error loading courses");
        }
    }
}