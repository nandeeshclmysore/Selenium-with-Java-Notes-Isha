package nagoor.java.oops;

class This{

    This(){
        this(10);
        System.out.println("Zero Arg");
    }

    This(int i){
        System.out.println("Single Arg");
    }
}
public class ThisKeyword {
    public static void main(String[] args) {
        This t=new This();
    }


}
