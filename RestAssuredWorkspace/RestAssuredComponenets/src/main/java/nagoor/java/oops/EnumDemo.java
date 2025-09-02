package nagoor.java.oops;

enum UserStatus{
    AVAILABLE,BUSY,IDLE;
}
public class EnumDemo {
    public static void main(String[] args) {
        System.out.println(UserStatus.AVAILABLE);
        System.out.println(UserStatus.BUSY);
        System.out.println(UserStatus.IDLE);
    }
}
