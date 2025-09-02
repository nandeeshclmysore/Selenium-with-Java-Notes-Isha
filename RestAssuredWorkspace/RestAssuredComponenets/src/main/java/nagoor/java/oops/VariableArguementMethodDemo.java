package nagoor.java.oops;

class Demo {
    public static int sum(int... a) {
        int sum = 0;
        System.out.println();
        System.out.println("Length is: "+a.length);
        for (int i : a) {
            sum = sum + i;
        }
        return sum;

    }
}

public class VariableArguementMethodDemo {
    public static void main(String[] args) {
        System.out.println("Sum is: " + Demo.sum(22, 33, 44, 55));
        System.out.println("Sum is: " + Demo.sum(22));
        System.out.println("Sum is: " + Demo.sum(1, 2, 3, 4, 5, 6));
    }
}
