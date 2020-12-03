package hw_14.services;

import hw_14.dao.AccountDao;
import hw_14.dao.AccountDaoImpl;
import hw_14.model.Account;

public class AccountServiceImpl implements AccountService{
    @Override
    public Account getById(int id) {
        AccountDao dao = new AccountDaoImpl();

        return dao.getById(id);
    }

    @Override
    public void save(Account account) {
        if(account == null) {
            System.out.println("Account is null");
            return;
        }

        AccountDao dao = new AccountDaoImpl();
        dao.save(account);
    }

    @Override
    public void update(Account account) {
        if(account == null) {
            System.out.println("Account is null");
            return;
        }

        AccountDao dao = new AccountDaoImpl();
        dao.update(account);
    }

    @Override
    public void delete(Account account) {
        if(account == null) {
            System.out.println("Account is null");
            return;
        }

        AccountDao dao = new AccountDaoImpl();
        dao.delete(account);
    }
}
