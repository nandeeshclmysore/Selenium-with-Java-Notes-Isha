package nagoor.java.oops;

class Employee {
    public int id;
    public String name;
    public double salary;
    public long mobile;

    public void setData(int id, String name, double salary, long mobile) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.mobile = mobile;
    }

    public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
        System.out.println("Employee Mobile: " + mobile);
    }
}

public class ClassDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setData(100, "Appu", 234.55, 9916454100l);
        e1.display();

        System.out.println("*********************************************");

        Employee e2 = new Employee();
        e2.setData(101, "Raghu", 234.55, 9916454100l);
        e2.display();
    }
}
