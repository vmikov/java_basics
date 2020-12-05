import hw_15.model.Account;
import hw_15.model.Client;
import hw_15.model.IdentityCode;
import hw_15.model.Status;
import hw_15.services.ClientService;
import hw_15.services.ClientServiceImpl;
import hw_15.services.StatusService;
import hw_15.services.StatusServiceImpl;

import java.math.BigDecimal;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        ClientService clSrv = new ClientServiceImpl();

        Client client = new Client(1,"Vasya", "vasya@vas.net", 380441234567L, "vasyl vasyliovych", 25);
        clSrv.save(client);
        client.setIdentityCode(new IdentityCode("1234567890", client));
        clSrv.update(client);

        StatusService stSrv = new StatusServiceImpl();
        Status st1 = new Status("User", "normal");
        Status st2 = new Status("Advanced user", "preveleged");
        stSrv.save(st1);
        stSrv.save(st2);

        Collection<Status> statuses = client.getStatuses();
        statuses.add(st1);
        statuses.add(st2);
        clSrv.update(client);

        Account account = new Account(client, "1234567890", new BigDecimal(String.valueOf(120000)));
        client.getAccounts().add(account);
        clSrv.update(client);
    }
}
