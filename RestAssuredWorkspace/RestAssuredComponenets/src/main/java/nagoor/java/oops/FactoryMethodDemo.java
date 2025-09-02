package nagoor.java.oops;

class F{
    private F(){}

    static F getRef(){
        return new F();
    }
}
public class FactoryMethodDemo {
    public static void main(String[] args) {
        F f=F.getRef();
        System.out.println(f);
    }
}
