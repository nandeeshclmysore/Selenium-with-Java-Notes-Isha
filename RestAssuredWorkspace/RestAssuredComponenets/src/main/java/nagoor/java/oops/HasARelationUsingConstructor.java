package nagoor.java.oops;

public class HasARelationUsingConstructor {
    public static void main(String[] args) {
        Account a=new Account();
        a.setAccid(100);
        a.setAccname("Saving");

        EmployeeClass e=new EmployeeClass("Appu",123.44,a);
        e.display();

    }
}
