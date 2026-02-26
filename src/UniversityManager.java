import java.util.*;
import java.util.stream.Stream;

public class UniversityManager {

    Map<String, UndergraduateStudent> undergraduateStudents = new HashMap<>();
    Map<String, GraduateStudent> graduateStudents = new HashMap<>();

    Map<String, Course> undergraduateCourses = new HashMap<>();
    Map<String, Course> graduateCourses = new HashMap<>();

    Map<String, Instructor> instructors = new HashMap<>();

    public UniversityManager() {
        FileManager.loadUndergraduates(undergraduateStudents);
        FileManager.loadGraduates(graduateStudents);
        FileManager.loadUndergraduateCourses(undergraduateCourses);
        FileManager.loadGraduateCourses(graduateCourses);
        FileManager.loadInstructors(instructors);
    }


    public void registerUndergraduate(UndergraduateStudent s) {
        if (undergraduateStudents.containsKey(s.getId()) || graduateStudents.containsKey(s.getId()))
            throw new RuntimeException("Student ID exists");
        undergraduateStudents.put(s.getId(), s);
    }

    public void registerGraduate(GraduateStudent s) {
        if (graduateStudents.containsKey(s.getId()) || undergraduateStudents.containsKey(s.getId()))
            throw new RuntimeException("Student ID exists");
        graduateStudents.put(s.getId(), s);
    }

    public void registerInstructor(Instructor i) {
        if (instructors.containsKey(i.getId()))
            throw new RuntimeException("Instructor ID exists");
        instructors.put(i.getId(), i);
    }

    public void createUndergraduateCourse(Course c) {
        if (undergraduateCourses.containsKey(c.getCourseId()) || graduateCourses.containsKey(c.getCourseId()))
            throw new RuntimeException("Course ID exists");
        undergraduateCourses.put(c.getCourseId(), c);
    }

    public void createGraduateCourse(Course c) {
        if (graduateCourses.containsKey(c.getCourseId()) || undergraduateCourses.containsKey(c.getCourseId()))
            throw new RuntimeException("Course ID exists");
        graduateCourses.put(c.getCourseId(), c);
    }


    public void enrollUndergraduate(String studentId, String courseId) {
        UndergraduateStudent student = undergraduateStudents.get(studentId);
        Course course = undergraduateCourses.get(courseId);
        if (student == null) throw new RuntimeException("Undergraduate not found");
        if (course == null) throw new RuntimeException("Course not found");
        course.enroll(student);
        student.addCourse(course);
    }

    public void enrollGraduate(String studentId, String courseId) {
        GraduateStudent student = graduateStudents.get(studentId);
        Course course = graduateCourses.get(courseId);
        if (student == null) throw new RuntimeException("Graduate not found");
        if (course == null) throw new RuntimeException("Course not found");
        course.enroll(student);
        student.addCourse(course);
    }


    public double calculateAverageGpa(String department) {
        return Stream.concat(undergraduateStudents.values().stream(), graduateStudents.values().stream())
                .filter(s -> s.getDepartment().equals(department))
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }

    public Student getTopStudent() {
        return Stream.concat(undergraduateStudents.values().stream(), graduateStudents.values().stream())
                .max(Comparator.comparingDouble(Student::getGpa))
                .orElse(null);
    }


    public void printStudents() {
        System.out.println("--- Undergraduates ---");
        undergraduateStudents.values().forEach(s -> System.out.println(s.getId()));
        System.out.println("--- Graduates ---");
        graduateStudents.values().forEach(s -> System.out.println(s.getId()));
    }

    public void printCourses() {
        System.out.println("--- Undergraduate Courses ---");
        undergraduateCourses.values().forEach(System.out::println);
        System.out.println("--- Graduate Courses ---");
        graduateCourses.values().forEach(System.out::println);
    }

    public void printInstructors() {
        System.out.println("--- Instructors ---");
        instructors.values().forEach(i -> System.out.println(i.getId() + " teaching " + i.getCourseName()));
    }


    public void saveAll() {
        FileManager.saveUndergraduates(undergraduateStudents);
        FileManager.saveGraduates(graduateStudents);
        FileManager.saveUndergraduateCourses(undergraduateCourses);
        FileManager.saveGraduateCourses(graduateCourses);
        FileManager.saveInstructors(instructors);
    }

    public double calculateUndergraduateTuition(String studentId, double flatRate) {
        UndergraduateStudent student = undergraduateStudents.get(studentId);
        if (student == null) throw new RuntimeException("Undergraduate not found");
        return student.calculateTuition(flatRate);
    }

    public double calculateGraduateTuition(String studentId, double perCreditRate) {
        GraduateStudent student = graduateStudents.get(studentId);
        if (student == null) throw new RuntimeException("Graduate not found");


        int totalCredits = student.getCoursesAndGrades().keySet().stream()
                .mapToInt(Course::getCredits)
                .sum();

        return totalCredits * perCreditRate + student.getResearchFee();
    }
}