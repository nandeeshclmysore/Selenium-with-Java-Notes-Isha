package CoreJavaForSpring;

class Student {

    String name;
    Student(String name) {
        System.out.println(this.name=name);
        System.out.println("I am Student Constructor");
    }
}

public class ConstructorDemo1 {


    public static void main(String[] args) {
        Student st1 = new Student("Appu");
        Student st2 = new Student("Raghu");


    }
}
