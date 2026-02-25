public class GraduateStudent extends Student {
    private double researchFees;

    public GraduateStudent(String id, String department, double gpa, double researchFees) {
        super(id, department, gpa);
        this.researchFees = researchFees;
    }

    public void setResearchFees(double researchFees) {
        this.researchFees = researchFees;
    }

    public double getResearchFees() {
        return researchFees;
    }

    @Override
    public double calculateTuition(double flatRate){
        return flatRate + researchFees;
    }
}