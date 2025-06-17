package javabasics;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void display() {
        System.out.println(this.name + " " + this.id + " " + this.salary);
    }

}

public class ConstructorDemo {

    public static void main(String[] args) {
        Employee e1 = new Employee("Appu", 22, 333.33);
        e1.display();
    }

}
