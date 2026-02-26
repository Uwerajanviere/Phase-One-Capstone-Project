public abstract class Person {

    protected String id;
    protected String department;

    public Person(String id, String department) {
        this.id = id;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }
}