package nagoor.java.oops;

class ObjectDemo{
    int a;
    float f=12.3f;
    char c='X';

    ObjectDemo(){
        c='A';
    }
}
public class ObjectCreationprocess {
    public static void main(String[] args) {
        ObjectDemo obj=new ObjectDemo();
        System.out.println(obj.a);
        System.out.println(obj.f);
        System.out.println(obj.c);

        //Hashcode of the object
        System.out.println(obj.hashCode());

        //Reference value of the object
        System.out.println(obj.toString());
        System.out.println(obj);
    }

}
