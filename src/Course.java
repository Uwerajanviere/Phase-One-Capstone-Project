import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String courseId;
    private String courseName;
    private int credits;

    public Course(String courseId , String courseName, int credits){
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }

    public String getCourseId() {
        return courseId;
    }



    List<Student> students = new ArrayList<>();
    Map<Course, Double > courses = new HashMap<>();




}
