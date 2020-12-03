package hw_14.dao;

import hw_14.model.Status;

public interface StatusDao {
    Status getById(int id);
    void save(Status status);
    void update(Status status);
    void delete(Status status);
}
