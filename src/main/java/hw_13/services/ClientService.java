package hw_13.services;

import hw_13.entities.Client;
import hw_13.utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientService {
    private static final String SQL_READ_ALL = "SELECT * FROM clients";
    private static final String SQL_READ = "SELECT * FROM clients WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE clients SET name=?, email=?, phone=?, about=?, age=? WHERE id=?";
    private static final String SQL_CREATE = "INSERT INTO clients (name, email, phone, about, age) VALUES (?,?,?,?,?)";
    private static final String SQL_DELETE = "DELETE FROM clients WHERE id=?";
    private static final String SQL_FIND_BY_PHONE = "SELECT * FROM clients WHERE phone=?";
    private static final String SQL_FIND_BY_ACCOUNT_CLIENT_ID = "SELECT c.* " +
                                                                "FROM clients c JOIN accounts a ON c.id = a.client_id " +
                                                                "WHERE c.id = ? " +
                                                                "FETCH FIRST 1 ROWS ONLY";
    private static final String SQL_FIND_GT_AGE = "SELECT c.*, s.alias " +
                                                  "FROM clients c JOIN client_status cs ON c.id = cs.client_id JOIN statuses s ON cs.status_id = s.id " +
                                                  "WHERE c.age > ?";

    public List<Client> readAll() {
        ArrayList<Client> items = new ArrayList<>();

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Client item = new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
                items.add(item);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return items;
    }

    public Client read (int id) {
        Client item = null;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_READ);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new Client(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getLong(4),
                    rs.getString(5),
                    rs.getInt(6)
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return item;
    }

    public boolean create (Client client) {
        int updateCount = 0;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_CREATE);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setLong(3, client.getPhone());
            ps.setString(4, client.getAbout());
            ps.setInt(5, client.getAge());

            updateCount = ps.executeUpdate();
            if (updateCount == 1) {
                conn.commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return updateCount == 1;
    }

    public boolean update(Client client) {
        int updateCount = 0;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, client.getName());
            ps.setString(2, client.getEmail());
            ps.setLong(3, client.getPhone());
            ps.setString(4, client.getAbout());
            ps.setInt(5, client.getAge());
            ps.setInt(6, client.getId());

            updateCount = ps.executeUpdate();
            if(updateCount == 1) {
                conn.commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return updateCount == 1;
    }

    public boolean delete (int id) {
        int updateCount = 0;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            updateCount = ps.executeUpdate();
            if(updateCount == 1) {
                conn.commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return updateCount == 1;
    }

    public Client findByPhone(long phone) {
        Client c = null;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_PHONE);
            ps.setLong(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public Client findByAccountClientId(int id) {
        Client c = null;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ACCOUNT_CLIENT_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    public Map<Client, String> findByGtAge(int age) {
        Map<Client, String> clients = new HashMap<>();

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_FIND_GT_AGE);
            ps.setInt(1, age);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client c = new Client(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getLong(4),
                        rs.getString(5),
                        rs.getInt(6)
                );
                String status = rs.getString(7);
                clients.put(c, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }
}
