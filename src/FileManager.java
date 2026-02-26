import java.io.*;
import java.util.Map;

public class FileManager {

    private static final String UG_FILE = "undergraduates.txt";
    private static final String GRAD_FILE = "graduates.txt";
    private static final String UG_COURSE_FILE = "undergraduate_courses.txt";
    private static final String GRAD_COURSE_FILE = "graduate_courses.txt";
    private static final String INSTRUCTOR_FILE = "instructors.txt";

    // ====== Students ======
    public static void saveUndergraduates(Map<String, UndergraduateStudent> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(UG_FILE))) {
            for (UndergraduateStudent s : students.values()) {
                writer.write(s.getId() + "," + s.getDepartment() + "," + s.getGpa());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving undergraduates");
        }
    }

    public static void loadUndergraduates(Map<String, UndergraduateStudent> students) {
        File file = new File(UG_FILE);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                UndergraduateStudent s = new UndergraduateStudent(data[0], data[1], Double.parseDouble(data[2]));
                students.put(s.getId(), s);
            }
        } catch (IOException e) {
            System.out.println("Error loading undergraduates");
        }
    }

    public static void saveGraduates(Map<String, GraduateStudent> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(GRAD_FILE))) {
            for (GraduateStudent s : students.values()) {
                writer.write(s.getId() + "," + s.getDepartment() + "," + s.getGpa());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving graduates");
        }
    }

    public static void loadGraduates(Map<String, GraduateStudent> students) {
        File file = new File(GRAD_FILE);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                GraduateStudent s = new GraduateStudent(data[0], data[1], Double.parseDouble(data[2]), 0);
                students.put(s.getId(), s);
            }
        } catch (IOException e) {
            System.out.println("Error loading graduates");
        }
    }

    // ====== Courses ======
    public static void saveUndergraduateCourses(Map<String, Course> courses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(UG_COURSE_FILE))) {
            for (Course c : courses.values()) {
                writer.write(c.getCourseId() + "," + c.getCourseName() + "," + c.getCredits());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving undergraduate courses");
        }
    }

    public static void loadUndergraduateCourses(Map<String, Course> courses) {
        File file = new File(UG_COURSE_FILE);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Course c = new Course(data[0], data[1], Integer.parseInt(data[2]));
                courses.put(c.getCourseId(), c);
            }
        } catch (IOException e) {
            System.out.println("Error loading undergraduate courses");
        }
    }

    public static void saveGraduateCourses(Map<String, Course> courses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(GRAD_COURSE_FILE))) {
            for (Course c : courses.values()) {
                writer.write(c.getCourseId() + "," + c.getCourseName() + "," + c.getCredits());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving graduate courses");
        }
    }

    public static void loadGraduateCourses(Map<String, Course> courses) {
        File file = new File(GRAD_COURSE_FILE);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Course c = new Course(data[0], data[1], Integer.parseInt(data[2]));
                courses.put(c.getCourseId(), c);
            }
        } catch (IOException e) {
            System.out.println("Error loading graduate courses");
        }
    }

    // ====== Instructors ======
    public static void saveInstructors(Map<String, Instructor> instructors) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(INSTRUCTOR_FILE))) {
            for (Instructor i : instructors.values()) {
                writer.write(i.getId() + "," + i.getDepartment() + "," + i.getCourseName());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving instructors");
        }
    }

    public static void loadInstructors(Map<String, Instructor> instructors) {
        File file = new File(INSTRUCTOR_FILE);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Instructor i = new Instructor(data[0], data[1], data[2]);
                instructors.put(i.getId(), i);
            }
        } catch (IOException e) {
            System.out.println("Error loading instructors");
        }
    }
}