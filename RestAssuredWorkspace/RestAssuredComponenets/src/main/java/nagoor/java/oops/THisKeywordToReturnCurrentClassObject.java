package nagoor.java.oops;

class Demo1 {

    Demo1 getObject() {
        return new Demo1();
    }

    Demo1 getObjectUsingThis() {
        return this;
    }
}

public class THisKeywordToReturnCurrentClassObject {


    public static void main(String[] args) {
        Demo1 d = new Demo1();

        System.out.println(d.getObject());
        System.out.println(d.getObject());

        System.out.println();

        System.out.println(d.getObjectUsingThis());
        System.out.println(d.getObjectUsingThis());

    }
}
