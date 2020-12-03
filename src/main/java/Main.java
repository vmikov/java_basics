import hw_14.model.Account;
import hw_14.model.Client;
import hw_14.model.Status;
import hw_14.services.*;
import org.hibernate.HibernateException;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        testStatuses();
        testAccounts();
        testClients();
    }

    private static void testAccounts() {
        AccountService srv = new AccountServiceImpl();
        try {
            Account account = new Account(2, "25252525", new BigDecimal(String.valueOf(15000)));
            srv.save(account);
            System.out.println(account);
            int id = account.getId();
            account.setValue(new BigDecimal(String.valueOf(10000)));
            srv.update(account);
            account = srv.getById(id);
            System.out.println(account);
            srv.delete(account);
            System.out.println(account);
        } catch (HibernateException e) {
            System.out.println("Hibernate exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }

    private static void testStatuses() {
        StatusService ss = new StatusServiceImpl();

        try {
            Status status = new Status("Super", "most powerful status");
            ss.save(status);
            System.out.println(status);
            int id = status.getId();
            status.setAlias("STD");
            status.setDescription("Standard client's status");
            ss.update(status);
            status = ss.getById(id);
            System.out.println(status);
            ss.delete(status);
            System.out.println(status);
        } catch (HibernateException e) {
            System.out.println("Hibernate exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }

    private static void testClients() {
        ClientService srv = new ClientServiceImpl();

        try {
            Client client = new Client("Client", "client@vas.net", new BigInteger(String.valueOf(123456789)), "some client", 50);
            srv.save(client);
            System.out.println(client);
            int id = client.getId();
            client.setName("Clientik");
            client.setPhone(new BigInteger(String.valueOf(987654321)));
            client.setAbout("some cool client");
            client.setAge(25);
            srv.update(client);
            client = srv.getById(id);
            System.out.println(client);
            srv.delete(client);
            System.out.println(client);

            client = srv.getByPhone(new BigInteger("380958089090"));
            System.out.println(client);
        } catch (HibernateException e) {
            System.out.println("Hibernate exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
    }
}
