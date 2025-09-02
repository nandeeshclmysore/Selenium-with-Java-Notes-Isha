package nagoor.java.oops;

class Demo3 {
    static int a = 10;
}

public class StaticVariables {
    public static void main(String[] args) {
        Demo3 d = new Demo3();
        System.out.println(d.a);
        System.out.println(Demo3.a);

        d = null;

        System.out.println(Demo3.a); //No NPE


    }
}
