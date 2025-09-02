package nagoor.java.oops.p1;

public class A {
    private double salary = 12345.55;
    int age = 34;
    protected String vehicle = "Audi";
    public String name = "Appu";

}

class B extends A {
    public void display() {
        //Same package with inheritance
        //Scope: Can access age[default], vehicle[protected],name[public]
        //Access through: direct access no need to create Object
        //Cannot access salary[private]

        //System.out.println(salary); private cannot be accessed outside the class
        System.out.println(age);
        System.out.println(vehicle);
        System.out.println(name);
    }
}

class C {
    public void display() {
        //Same package without inheritance
        //Scope: Can access age[default], vehicle[protected],name[public]
        //Access through: Need to create Object
        //Cannot access salary[private]

        //System.out.println(salary); private cannot be accessed outside the class
        A a=new A();
        System.out.println(a.age);
        System.out.println(a.vehicle);
        System.out.println(a.name);
    }
}

