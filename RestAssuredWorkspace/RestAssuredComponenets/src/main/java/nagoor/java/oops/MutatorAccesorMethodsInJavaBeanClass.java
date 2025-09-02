package nagoor.java.oops;

class Employe {

    String name;
    int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

public class MutatorAccesorMethodsInJavaBeanClass {
    public static void main(String[] args) {
        Employe e = new Employe();
        e.setId(100);
        e.setName("Appu");

        System.out.println(e.getId());
        System.out.println(e.getName());
    }
}
