package JavaForRestassured;

//In Java, the method codePointAt(int index) is used with String, StringBuffer, or StringBuilder.

public class CodePointExample {

    public static void main(String[] args) {
        String str = "A😊C";  // contains a surrogate pair (😊)

        // Normal charAt()
        System.out.println("charAt(1): " + str.charAt(1));
        // Prints part of emoji (not full)

        // Using codePointAt()
        int codePoint = str.codePointAt(1);
        System.out.println("codePointAt(1): " + codePoint);
        System.out.println("Character: " + new String(Character.toChars(codePoint)));
    }


}
