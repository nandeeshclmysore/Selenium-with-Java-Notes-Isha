package nagoor.java.oops.p2;
import nagoor.java.oops.p1.A;

public class C  extends A {
    public void display(){
        //Different package with inheritance
        //Scope: Can access vehicle[protected],name[public]
        //Access through: direct access no need to create Object
        //Cannot access salary[private], age[default]
        //Even import cannot access private and default members outside package

        //System.out.println(salary); private outside class cannot be accessed
        //System.out.println(age); default outside package cannot be accessed
        System.out.println(vehicle);
        System.out.println(name);

    }

}

class D{
    public void display(){
        //Different package without inheritance
        //Scope: Can access name[public]
        //Access through: Need to create Object
        //Cannot access salary[private], age[default], vehicle[protected]
        //Even import cannot access private, default and protected members outside package

        //System.out.println(salary); private outside class cannot be accessed
        //System.out.println(age); default outside package cannot be accessed
        //System.out.println(vehicle); protected outside package without inheritance cannot be accessed

        A a=new A();
        System.out.println(a.name);
    }

}
