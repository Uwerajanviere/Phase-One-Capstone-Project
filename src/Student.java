public class Student extends Person{

private double gpa;


    public Student(String id, String department, double gpa){
        super(id, department);
        this.gpa = gpa;

    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }


    public double calculateTuition(double flatRate){

        return flatRate;


    }

}
