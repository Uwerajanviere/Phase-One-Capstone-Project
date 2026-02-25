import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UniversityManager {

    List<Student> allRegisteredStudents = new ArrayList<>();
    List<Course> courses = new ArrayList<>();


    public UniversityManager() {
        FileManager.loadStudents(allRegisteredStudents);
        FileManager.loadCourses(courses);
    }

    public void registerStudent(Student student){
        allRegisteredStudents.add(student);
    }

    public void createCourse(String id, String name, int credits){
        courses.add(new Course(id, name, credits));
    }

    public void enrollStudentInCourse(Course course, Student student){
        if (!allRegisteredStudents.contains(student.getId())) {
            System.out.println("Student must register first!");
            return;
        }
        course.enroll(student);
        student.addCourse(course);
    }


    public double calculateAverageGpa(String department) {
        return allRegisteredStudents.stream()
                .filter(s -> s.getDepartment().equals(department))
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }


    public Student getTopStudent() {
        return allRegisteredStudents.stream()
                .max((s1, s2) -> Double.compare(s1.getGpa(), s2.getGpa()))
                .orElse(null);
    }


    public void printHighPerformingStudents() {
        allRegisteredStudents.stream()
                .filter(s -> s.getGpa() > 3.5)
                .forEach(s -> System.out.println("HighPerformingStudents: " + s.getId()));
    }

    public void printCourses() {
        System.out.println(courses);
    }


    public void saveAll() {
        FileManager.saveStudents(allRegisteredStudents);
        FileManager.saveCourses(courses);
    }
    public Student findStudentById(String id) {
        for (Student s : allRegisteredStudents) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public Course findCourseById(String id) {
        for (Course c : courses) {
            if (c.getCourseId().equals(id)) {
                return c;
            }
        }
        return null;
    }
}