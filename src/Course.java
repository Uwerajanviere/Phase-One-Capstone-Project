import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseId;
    private String courseName;
    private int credits;
    private int maxStudents = 20;

    List<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void enroll(Student student) {
        if (enrolledStudents.size() >= maxStudents) {
            throw new RuntimeException("Course is full");
        }
        if (enrolledStudents.contains(student)) {
            throw new RuntimeException("Student already enrolled in this course");
        }
        enrolledStudents.add(student);
    }

    public int getEnrollmentCount() {
        return enrolledStudents.size();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", enrolledStudents=" + enrolledStudents.size() +
                '}';
    }
}