import java.util.Date;

public class Employee {
    String name;
    int sal;
    double percent;
    Date birth;

    Employee (String name, Date bitrh, int sal, double percent) {
        setName(name);
        setBirth(bitrh);
        setSal(sal);
        setPercent(percent);
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
