package problemdomain;

public class Salaried extends Employee {
    //attributes
    private double salary;

    public Salaried() {
    }

    public Salaried(String id, String name, String address, String phone, long sin, String dob, String dept,
                    double salary) {
        super(id, name, address, phone, sin, dob, dept);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPay() {
        return salary / 52; //Weekly pay = annual salary /52
    }

    @Override
    public String toString() {
        return "Salaried{" +
                "salary=" + salary +
                '}';
    }
}
