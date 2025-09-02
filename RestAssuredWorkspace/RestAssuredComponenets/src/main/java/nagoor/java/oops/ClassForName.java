package nagoor.java.oops;

class X{
    static {
        System.out.println("SB");
    }

    X(){
        System.out.println("Const");
    }
}
public class ClassForName {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c=Class.forName("nagoor.java.oops.X");
        System.out.println(c.getConstructors());
        System.out.println(c.getName());
        System.out.println(c.getDeclaredMethods());
    }
}
