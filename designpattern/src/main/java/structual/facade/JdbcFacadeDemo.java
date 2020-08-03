package structual.facade;

import java.util.List;

public class JdbcFacadeDemo {

    public static void main(String[] args) {

        JdbcFacade facade = new JdbcFacade();
        facade.createTable();

        System.out.println("Table created");

        facade.insertIntoTable();
        System.out.println("Record(s) inserted");

        List<Address> addresses = facade.getAddresses();

        for (Address adr : addresses)
            System.out.printf("%s %s %s\n", adr.getId(), adr.getStreetName(), adr.getCity());

    }

}
