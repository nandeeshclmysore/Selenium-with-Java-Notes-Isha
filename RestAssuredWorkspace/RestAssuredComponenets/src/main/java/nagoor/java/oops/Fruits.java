package nagoor.java.oops;

public class Fruits {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AppleDemo1 getA() {
        return a;
    }

    public void setA(AppleDemo1 a) {
        this.a = a;
    }

    private String id;
    private AppleDemo1 a;

    public void display(){
        System.out.println("Fruit ID"+getId());
        System.out.println("Fruit price"+a.getPrice());
    }



}
