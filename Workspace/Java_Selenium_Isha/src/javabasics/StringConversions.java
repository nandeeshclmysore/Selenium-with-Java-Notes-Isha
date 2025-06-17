package javabasics;

public class StringConversions {
    public static void main(String[] args) {
        String a="1";
        String b="2.4";

        int x=Integer.parseInt(a);
        double y=Double.parseDouble(b);

        System.out.println(a+" "+x);
        System.out.println(b+" "+y);
    }
}
