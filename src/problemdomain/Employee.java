package problemdomain;

public abstract class Employee {
    //attributes
    private String id;
    private String name;
    private String address;
    private String phone;
    private long sin;
    private String dob;
    private String dept;

    public Employee() {
    }

    public Employee(String id, String name, String address, String phone, long sin, String dob, String dept) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.sin = sin;
        this.dob = dob;
        this.dept = dept;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getSin() {
        return sin;
    }

    public void setSin(int sin) {
        this.sin = sin;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public abstract double getPay();

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", sin=" + sin +
                ", dob='" + dob + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
