package hw_13.services;

import hw_13.entities.Status;
import hw_13.utils.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusService {
    private static final String SQL_READ_ALL = "SELECT * FROM statuses";
    private static final String SQL_READ = "SELECT * FROM statuses WHERE id=?";
    private static final String SQL_UPDATE = "UPDATE statuses SET alias=?, description=? WHERE id=?";
    private static final String SQL_CREATE = "INSERT INTO statuses (alias, description) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM statuses WHERE id=?";

    public List<Status> readAll() {
        ArrayList<Status> items = new ArrayList<>();

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_READ_ALL);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Status item = new Status(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }

    public Status read(int id) {
        Status item = null;
        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_READ);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                item = new Status(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public boolean create (Status status) {
        int updateCount = 0;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_CREATE);
            ps.setString(1, status.getAlias());
            ps.setString(2, status.getDescription());
            updateCount = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateCount == 1;
    }

    public boolean update (Status status) {
        int updateCount = 0;

        try (Connection conn = Database.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, status.getAlias());
            ps.setString(2, status.getDescription());
            ps.setInt(3, status.getId());
            updateCount = ps.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateCount == 1;
    }

    public boolean delete (int id) {
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
}
