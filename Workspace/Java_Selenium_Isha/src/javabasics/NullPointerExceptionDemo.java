package javabasics;

class Student {
    String name;

    void display() {
        System.out.println("name is: " + name);
    }
}

public class NullPointerExceptionDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Appu";
        s1.display();

        Student s2 = new Student();
        s2 = s1;
        s2.display();


    }
}
