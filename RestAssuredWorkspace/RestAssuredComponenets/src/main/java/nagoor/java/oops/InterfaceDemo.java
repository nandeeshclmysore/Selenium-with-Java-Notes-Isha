package nagoor.java.oops;

interface A {
    int x = 10; //public static final

    void m1(); //public abstract

    void m2(); //public abstract
}

class B implements A {

    @Override
    public void m1() {
        System.out.println("m1 method of interface");
    }

    @Override
    public void m2() {
        System.out.println("m2 method of interface");
    }

    public void m3() {
        System.out.println("m3 method of implementation class");
    }
}

public class InterfaceDemo {

    public static void main(String[] args) {
        A a = new B();
        a.m1();
        a.m2();
        //a.m3();  Cannot access method of imp class

        B b = new B();
        b.m1();
        b.m2();
        b.m3();

        //Interface variable can be accesses through Interface name, Implementation Class name, Interface
        //reference variable, Implementation Class reference variable
        System.out.println(A.x);
        System.out.println(B.x);
        System.out.println(a.x);
        System.out.println(b.x);


    }


}
