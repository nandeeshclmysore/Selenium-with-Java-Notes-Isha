package nagoor.java.oops;


class A1 {
    static A1 a = null;// a=a111
    private A1(){
        //System.out.println("A-Con");
    }
    static A1 getRef() {
        if(a == null) {
            a = new A1();//A@a111
        }
        return a;
    }
}

public class SingletonClassDemo {

    public static void main(String[] args) {
        A1 a1 = A1.getRef();// a1 = A@a111
        A1 a2 = A1.getRef();// a2 = A@a111
        A1 a3 = A1.getRef();// a3 = A@a111

        System.out.println(a1);// A@a111
        System.out.println(a2);// A@a111
        System.out.println(a3);// A@a111

    }
}
