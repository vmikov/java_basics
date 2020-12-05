package hw_15.services;

import hw_15.model.Account;

public interface AccountService {
    Account getById(int id);
    void save(Account account);
    void update(Account account);
    void delete(Account account);
}
