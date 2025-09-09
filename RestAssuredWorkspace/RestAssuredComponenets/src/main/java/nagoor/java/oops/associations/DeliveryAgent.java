package nagoor.java.oops.associations;




public class DeliveryAgent {
    private String agentId;
    private String agentName;
    private String agentMobileNo;
    private String customerName;
    private Item[] items;


    public DeliveryAgent(String agentId, String agentName, String agentMobileNo, String customerName, Item[] items) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.agentMobileNo = agentMobileNo;
        this.customerName = customerName;
        this.items = items;
    }


    public void getDeliveryDetails(){
        System.out.println("Item Delivery Details");
        System.out.println("--------------------------");
        System.out.println("Delivery Agent Id       : "+agentId);
        System.out.println("Delivery Agent Name     : "+agentName);
        System.out.println("Delivery Agent Mobile   : "+agentMobileNo);
        System.out.println("Customer Name           : "+customerName);
        System.out.println();
        System.out.println("ITEM ID\tITEM NAME\tPRICE\tPAYMODE\tDELIVERDATE");
        System.out.println("----------------------------------------------------");
        for(int index = 0; index < items.length; index++){
            Item item = items[index];
            System.out.print(item.getItemId()+"\t");
            System.out.print(item.getItemName()+"\t\t");
            System.out.print(item.getPrice()+"\t");
            System.out.print(item.getPaymentMode()+"\t\t");
            System.out.print(item.getDeliveryDate()+"\n");
        }
    }
}

