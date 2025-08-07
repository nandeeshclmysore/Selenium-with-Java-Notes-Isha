package JavaForRestassured;

public class HeloWorld {
    public static void main(String[] args) {

        System.out.println("Hello World !!");
        System.out.println(555 + 888 - 222 * 6666);

        //BODMAS Rule else default execution is Left to Right Execution
        System.out.println("Sum of " + 555 + 555);  //Sum of 555555 -> Left to Right execution so Concatenation
        System.out.println(555 + 555+" Sum is"); //1110 Sum is
        System.out.println(555 + 555+" Sum is"+6666+666); //1110 Sum is6666666

        System.out.println((555 + 555)+" Sum is"+(6666+666)); //1110 Sum is7332

    }
}
