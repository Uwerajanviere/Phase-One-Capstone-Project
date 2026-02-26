import java.util.HashMap;
import java.util.Map;

public class Student extends Person {

    private double gpa;

    Map<Course, Double> coursesAndGrades = new HashMap<>();

    public Student(String id, String department, double gpa) {
        super(id, department);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double calculateTuition(double rate) {
        return rate;
    }

    public void addCourse(Course course) {
        if (coursesAndGrades.containsKey(course)) {
            throw new RuntimeException("Student already enrolled in this course");
        }
        coursesAndGrades.put(course, 0.0);
    }

    public void setGrade(Course course, double grade) {
        coursesAndGrades.put(course, grade);
    }

    public Map<Course, Double> getCoursesAndGrades() {
        return coursesAndGrades;
    }
}