package nagoor.java.oops;

abstract class Student{

    int a=10;

    public void m1(){
        System.out.println("Abstract class method");
    }

    abstract public void m2();
}

class CSE extends Student{

    @Override
    public void m2() {
        System.out.println("Abstract class implemented method");
    }

    public void m3(){
        System.out.println("Implementation class own method");
    }
}
public class AbstractClassDemo {

    public static void main(String[] args) {

        Student s=new CSE();
        s.m1();
        s.m2();
        //s.m3(); Cannot access child class method

        CSE c=new CSE();
        c.m1();
        c.m2();
        c.m3();

    }
}
