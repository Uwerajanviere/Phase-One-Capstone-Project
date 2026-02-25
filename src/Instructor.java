public class Instructor extends Person {
    String courseName;

    public Instructor(String id, String department, String courseName){
        super(id, department);
        this.courseName = courseName;
    }
}