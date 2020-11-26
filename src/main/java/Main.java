import hw_13.entities.Account;
import hw_13.entities.Client;
import hw_13.entities.Status;
import hw_13.services.AccountService;
import hw_13.services.ClientService;
import hw_13.services.StatusService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        checkHW13();
    }

    public static void checkHW13 () {
        //checkAccounts();
        //checkStatuses();
        checkClients();
    }

    public static void checkAccounts() {
        AccountService accountService = new AccountService();

        List<Account> accounts = accountService.readAll();
        accounts.forEach(System.out::println);

        Account a = accountService.read(1);
        System.out.println(a);

        a.setValue(new BigDecimal(String.valueOf(330.00)));
        accountService.update(a);

        a = accountService.read(1);
        System.out.println(a);

        Account newAccount = new Account(0, 2, "1234567890", new BigDecimal(String.valueOf(25000.5)));
        accountService.create(newAccount);

        accountService.readAll().forEach(System.out::println);

        accountService.delete(21);
        a = accountService.read(21);
        System.out.println(a);

        accounts = accountService.findByGtValue(new BigDecimal(String.valueOf(10000)));
        accounts.forEach(System.out::println);
    }

    public static void checkStatuses() {
        StatusService statusService = new StatusService();

        List<Status> statuses = statusService.readAll();
        statuses.forEach(System.out::println);

        Status s = statusService.read(1);
        System.out.println(s);

        Status newStatus = new Status(0, "TEST", "TEST status");
        boolean succeeded = statusService.create(newStatus);
        System.out.println(succeeded ? "status created" : "status creation error");

        statuses = statusService.readAll();
        statuses.forEach(System.out::println);

        s = statusService.read(6);
        s.setAlias("TESTik");
        statusService.update(s);
        s = statusService.read(6);
        System.out.println(s);
        statusService.delete(6);
        s = statusService.read(6);
        System.out.println(s);
    }

    public static void checkClients() {
        ClientService clSrv = new ClientService();

        List<Client> clients = clSrv.readAll();
        clients.forEach(System.out::println);

        Client c = clSrv.read(1);
        System.out.println(c);

        Client newClient = new Client(0, "TEST", "test@vas.net", 999999999, "TEST client", 1000);
        boolean succeeded = clSrv.create(newClient);
        System.out.println(succeeded ? "client created" : "client creation error");

        clients = clSrv.readAll();
        clients.forEach(System.out::println);

        c = clSrv.read(14);
        c.setPhone(1000500020);
        clSrv.update(c);
        System.out.println(c);
        clSrv.delete(14);
        c = clSrv.read(14);
        System.out.println(c);

        c = clSrv.findByPhone(951234576);
        System.out.println(c);

        Client client = clSrv.findByAccountClientId(10);
        System.out.println(client);

        Map<Client, String> clientMap = clSrv.findByGtAge(18);
        clientMap.forEach((key,value) -> System.out.println(key + ", " + value));
    }
}
