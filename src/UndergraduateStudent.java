public class UndergraduateStudent extends Student{

    public UndergraduateStudent(String id, String department, double gpa) {
        super(id, department, gpa);

    }

    @Override
    public double calculateTuition(double flatRate){
        return flatRate;

    }
}
