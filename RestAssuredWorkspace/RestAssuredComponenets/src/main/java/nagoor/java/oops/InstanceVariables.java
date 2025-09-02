package nagoor.java.oops;

class Instance {
    int a = 10;

    {
        System.out.println("I am Instance Block");
    }

    Instance(){
        System.out.println("I am Constructor");
    }
}

public class InstanceVariables {
    public static void main(String[] args) {
        Instance i = new Instance();
        System.out.println(i.a);

        Instance i2 = new Instance();
        System.out.println(i2.a);

//        i = null;
//
//        try{
//            System.out.println(i.a);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }


        System.out.println("End ");
    }
}
