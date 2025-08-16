package CoreJavaForSpring;

class Geeks {

    // data members of the class
    String name;
    int id;
    int age;

    Geeks(String name, int id) {
        this.name = name;
        this.id = id;
    }
}


public class ParameterizedConstructor {

    public static void main(String[] args)
    {
        // This would invoke the parameterized constructor
        Geeks geek1 = new Geeks("Sweta", 68);
        System.out.println("GeekName: " + geek1.name
                + " and GeekId: " + geek1.id+" and GeekAge: "+geek1.age);
    }

}
