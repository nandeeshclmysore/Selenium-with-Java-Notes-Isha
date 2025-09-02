package JavaForRestassured;

class Animal {

    public void sleep() {
        System.out.println("The animal is sleeping.");
    }

    public void eat() {
        System.out.println("The animal is eating.");
    }


}

class Cat extends Animal {

    public void meow() {
        System.out.println("The cat is meowing.");
    }

    @Override
    public void eat() {
        System.out.println("The Cat is eating.");
    }
}


public class UpAndDowncasting {

    public static void main(String[] args) {

        System.out.println("Object for Parent Reference for parent");
        Animal a = new Animal();
        a.eat();
        a.sleep();

        System.out.println("Object for Child Reference for Child");
        Cat c = new Cat();
        c.meow();
        c.eat();
        c.sleep();

        //Implicit Upcasting
        System.out.println("Object for Child Reference for Parent");
        Animal a1 = new Cat();
        a1.sleep();
        a1.eat();

        // Explicit downcasting
        System.out.println("Object for Parent Reference for Child using Cast Operator");
        Cat c1 = (Cat) new Animal();
        c1.eat();
        c1.sleep();
        c1.meow();

    }
}

