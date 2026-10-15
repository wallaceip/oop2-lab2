package problemdomain;

public class PartTime extends Employee {
    private double rate;
    private double hours;

    public PartTime(String id, String name, String address, String phone, long sin, String dob, String dept,
                    double rate, double hours) {
        super(id, name, address, phone, sin, dob, dept);
        this.rate = rate;
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getPay() {
        return hours * rate;
    }

    @Override
    public String toString() {
        return "PartTime{" +
                "rate=" + rate +
                ", hours=" + hours +
                '}';
    }
}
