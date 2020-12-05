package hw_15.dao;

import hw_15.model.Status;

public interface StatusDao {
    Status getById(int id);
    void save(Status status);
    void update(Status status);
    void delete(Status status);
}
