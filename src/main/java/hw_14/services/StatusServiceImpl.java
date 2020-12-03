package hw_14.services;

import hw_14.dao.StatusDao;
import hw_14.dao.StatusDaoImpl;
import hw_14.model.Status;

public class StatusServiceImpl implements StatusService{
    @Override
    public Status getById(int id) {
        StatusDao dao = new StatusDaoImpl();

        return dao.getById(id);
    }

    @Override
    public void save(Status status) {
        if(status == null) {
            System.out.println("Status is null");
            return;
        }

        StatusDao dao = new StatusDaoImpl();
        dao.save(status);
    }

    @Override
    public void update(Status status) {
        if(status == null) {
            System.out.println("Status is null");
            return;
        }

        StatusDao dao = new StatusDaoImpl();
        dao.update(status);
    }

    @Override
    public void delete(Status status) {
        if(status == null) {
            System.out.println("Status is null");
            return;
        }

        StatusDao dao = new StatusDaoImpl();
        dao.delete(status);
    }
}
