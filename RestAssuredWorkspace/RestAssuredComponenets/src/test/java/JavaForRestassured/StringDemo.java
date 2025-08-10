package JavaForRestassured;

public class StringDemo {
    public static void main(String[] args) {

        String s1 = "Appu is BOSS !";
        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        //System.out.println(s1.isBlank()); To check string contains only white spaces
        System.out.println(s1.charAt(3));
        System.out.println(s1.contains("is"));
        System.out.println(s1.startsWith("Appu"));
        System.out.println(s1.indexOf("BOSS"));
        System.out.println(s1.replace("Appu", "Surya"));
        System.out.println(s1.trim());
        String s[] = s1.split(" ");
        for (String x : s) {
            System.out.println(x);
        }

        char c[] = s1.toCharArray();
        for (char y : c) {
            System.out.println(y);
        }

        System.out.println(s1.equals("Vishnu"));

        System.out.println(s1.toUpperCase().contains("APPU"));
        System.out.println(s1.toLowerCase().contains("APPU"));
        System.out.println(s1.toLowerCase().compareToIgnoreCase("APPU"));

        System.out.println(s1.substring(3, 9));

        try {
            System.out.println(s1.substring(39));
        } catch (Exception e) {
            System.out.println("OH My God !");
        }

        System.out.println("End of Apps");


    }
}
