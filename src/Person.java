public abstract class Person {
private  String id;
private String department;

public Person(String id , String department){
    this.id = id;
    this.department = department;
}

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public String getId() {
        return id;
    }


}
