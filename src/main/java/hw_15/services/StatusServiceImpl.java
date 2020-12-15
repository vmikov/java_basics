package hw_15.services;

import hw_15.dao.StatusDao;
import hw_15.dao.StatusDaoImpl;
import hw_15.model.Status;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

public class StatusServiceImpl implements StatusService {
    Logger logger = Logger.getLogger(StatusServiceImpl.class);

    @Override
    public Status getById (int id) {
        logger.debug("StatusServiceImpl.getById(int id) method invoked with parameters: id = " + id);

        StatusDao dao = new StatusDaoImpl();
        Status status = null;

        try {
            status = dao.getById(id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }

        return status;
    }

    @Override
    public void save (Status status) {
        logger.debug("StatusServiceImpl.save(Status status) method invoked with parameters: status = " + status);

        if(status == null) {
            logger.error("no status to save in the method StatusServiceImpl.save(Status status): status = null");
            return;
        }

        StatusDao dao = new StatusDaoImpl();

        try {
            dao.save(status);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void update(Status status) {
        logger.debug("StatusServiceImpl.update(Status status) method invoked with parameters: status = " + status);

        if(status == null) {
            logger.error("no status to update in the method StatusServiceImpl.update(Status status): status = null");
            return;
        }

        StatusDao dao = new StatusDaoImpl();

        try {
            dao.update(status);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(Status status) {
        logger.debug("StatusServiceImpl.delete(Status status) method invoked with parameters: status = " + status);

        if(status == null) {
            logger.error("no status to delete in the method StatusServiceImpl.delete(Status status): status = null");
            return;
        }

        StatusDao dao = new StatusDaoImpl();

        try {
            dao.delete(status);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }
}
