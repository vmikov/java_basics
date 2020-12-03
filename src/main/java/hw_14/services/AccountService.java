package hw_14.services;

import hw_14.model.Account;

public interface AccountService {
    Account getById(int id);
    void save(Account account);
    void update(Account account);
    void delete(Account account);
}
