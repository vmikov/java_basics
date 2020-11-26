package hw_13.services;

import hw_13.entities.Account;
import hw_13.utils.Database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private static final String SQL_READ_ALL = "SELECT * FROM accounts";
    private static final String SQL_READ = "SELECT * FROM accounts WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE accounts SET client_id=?, number=?, value=? WHERE id=?";
    private static final String SQL_CREATE = "INSERT INTO accounts (client_id, number, value) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM accounts WHERE id=?";
    private static final String SQL_GET_GT_VALUE = "SELECT * FROM accounts WHERE value > ?";

    public List<Account> readAll() {
        ArrayList<Account> items = new ArrayList<>();

        try(Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Account item = new Account(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getBigDecimal(4)
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public Account read(int id) {
        Account item = null;

        try(Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_READ);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                item = new Account(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getBigDecimal(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

    public boolean update(Account account) {
        int updateCount = 0;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(1, account.getClientId());
            ps.setString(2, account.getNumber());
            ps.setBigDecimal(3, account.getValue());
            ps.setInt(4, account.getId());
            updateCount = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateCount == 1;
    }

    public boolean create(Account account) {
        int updateCount = 0;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_CREATE);
            ps.setInt(1, account.getClientId());
            ps.setString(2, account.getNumber());
            ps.setBigDecimal(3, account.getValue());
            updateCount = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateCount == 1;
    }

    public boolean delete(int id) {
        int updateCount = 0;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            updateCount = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateCount == 1;
    }

    public List<Account> findByGtValue(BigDecimal value) {
        List<Account> items = new ArrayList<>();

        try (Connection conn = Database.getConnection()){
            PreparedStatement ps = conn.prepareStatement(SQL_GET_GT_VALUE);
            ps.setBigDecimal(1, value);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Account a = new Account(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getBigDecimal(4)
                );
                items.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }
}
