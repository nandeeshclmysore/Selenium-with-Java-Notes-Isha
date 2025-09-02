package nagoor.java.oops;

enum Apple {
    A(1), B(2), C(3);

    int price;

    Apple(int price) {
        this.price = price;
    }

    int getprice() {
        return price;
    }

}

public class EnumDemo2 {

    public static void main(String[] args) {
        System.out.println(Apple.A.getprice());
        System.out.println(Apple.B.getprice());
        System.out.println(Apple.C.getprice());
    }
}
