package hw_4.services;

import hw_4.entities.Client;
import hw_4.utils.TransactionValidator;

public class TransactionService {
    public static void transfer(Client client, String account) {
        TransactionValidator.validateTransactionAccounts(client.getAccount(), account);
    }
}
