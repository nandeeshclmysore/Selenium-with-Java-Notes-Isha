package nagoor.java.oops;

public class MutableAndImmutableObjects {
    public static void main(String[] args) {

            String str1 = new String("Durga ");
            String str2 = str1.concat("Software ");
            String str3 = str2.concat("Solutions");
            System.out.println(str1);// Durga
            System.out.println(str2);// Durga Software
            System.out.println(str3);// Durga Software Solutions
            System.out.println();

            StringBuffer sb1 = new StringBuffer("Durga ");
            StringBuffer sb2 = sb1.append("Software ");
            StringBuffer sb3 = sb2.append("Solutions");
            System.out.println(sb1);// Durga Software Solutions
            System.out.println(sb2);// Durga Software Solutions
            System.out.println(sb3);// Durga Software Solutions
    }
}
