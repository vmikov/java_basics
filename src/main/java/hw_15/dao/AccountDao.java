package hw_15.dao;

import hw_15.model.Account;

public interface AccountDao {
    Account getById(int id);
    void save(Account account);
    void update(Account account);
    void delete(Account account);
}
