public class GraduateStudent extends Student {

    private double researchFee;

    public GraduateStudent(String id, String department, double gpa, double researchFee) {
        super(id, department, gpa);
        this.researchFee = researchFee;
    }

    @Override
    public double calculateTuition(double perCreditRate) {
        return perCreditRate + researchFee;
    }
    public double getResearchFee() {
        return researchFee;
    }
}