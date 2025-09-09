package nagoor.java.oops.associations;

public class OneToOneAssociation {

    public static void main(String[] args) {
        Account account = new Account();
        account.setAccNo("abc123");
        account.setAccHolderName("Durga");
        account.setAccType("Savings");
        account.setBalance(50000);

        Employee employee = new Employee();
        employee.setEno(111);
        employee.setEname("Durga");
        employee.setEsal(50000);
        employee.setEaddr("Hyd");
        employee.setAccount(account);

        employee.getEmployeeDetails();
    }

}
