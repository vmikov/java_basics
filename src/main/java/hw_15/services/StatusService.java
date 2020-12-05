package hw_15.services;

import hw_15.model.Status;

public interface StatusService {
    Status getById(int id);
    void save(Status status);
    void update(Status status);
    void delete(Status status);
}
