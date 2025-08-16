package CoreJavaForSpring;

public class InitBlockDemo {

    // block to be executed before any constructor.
    {
        System.out.println("init block");
    }

    // no-arg constructor
    InitBlockDemo()
    {
        System.out.println("default");
    }

    // constructor with one argument.
    InitBlockDemo(int x)
    {
        System.out.println(x);
    }

    public static void main(String[] args)
    {
        // Object creation by calling no-argument
        // constructor.
        new InitBlockDemo();

        // Object creation by calling parameterized
        // constructor with one parameter.
        new InitBlockDemo(10);
    }
}
