package nagoor.java.oops;

public class HASARelationUsingSettermethod {
    public static void main(String[] args) {

        AppleDemo1 a = new AppleDemo1();
        a.setPrice(10000);

        Fruits f = new Fruits();
        f.setId("123");
        f.setA(a);

        f.display();
    }
}
