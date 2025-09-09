package nagoor.java.oops;

public class EmployeeClass {

    public double getSalary() {
        return salary;
    }

    public String getEname() {
        return ename;
    }

    public EmployeeClass(String ename, double salary,Account account ) {
        this.ename = ename;
        this.account = account;
        this.salary = salary;
    }

    private String ename;
    private double salary;
    private Account account;

    public void display(){
        System.out.println(ename);
        System.out.println(salary);
        System.out.println(account.getAccid());
        System.out.println(account.getAccname());
    }
}
