package hw_14.services;

import hw_14.model.Status;

public interface StatusService {
    Status getById(int id);
    void save(Status status);
    void update(Status status);
    void delete(Status status);
}
