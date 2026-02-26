public class Instructor extends Person {

    private String courseName;

    public Instructor(String id, String department, String courseName) {
        super(id, department);
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}