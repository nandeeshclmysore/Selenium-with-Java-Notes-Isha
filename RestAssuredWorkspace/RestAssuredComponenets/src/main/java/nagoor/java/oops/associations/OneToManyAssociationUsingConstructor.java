package nagoor.java.oops.associations;

public class OneToManyAssociationUsingConstructor {

    public static void main(String[] args) {
        Item item1 = new Item();
        item1.setItemId("I-111");
        item1.setItemName("Mobile");
        item1.setPrice(25000);
        item1.setPaymentMode("COD");
        item1.setDeliveryDate("11-03-2023");


        Item item2 = new Item();
        item2.setItemId("I-222");
        item2.setItemName("Shirt");
        item2.setPrice(2500);
        item2.setPaymentMode("UPI");
        item2.setDeliveryDate("11-03-2023");


        Item item3 = new Item();
        item3.setItemId("I-333");
        item3.setItemName("Laptop");
        item3.setPrice(50000);
        item3.setPaymentMode("UPI");
        item3.setDeliveryDate("11-03-2023");


        Item[] items = {item1, item2, item3};


        DeliveryAgent deliveryAgent = new DeliveryAgent("D111", "Anil", "9988776655", "Durga", items);
        deliveryAgent.getDeliveryDetails();


    }

}
