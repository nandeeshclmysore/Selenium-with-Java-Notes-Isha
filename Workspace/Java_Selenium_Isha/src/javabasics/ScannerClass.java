package javabasics;

import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String greet=sc.next();
        System.out.println("Hello "+greet);
    }
}
