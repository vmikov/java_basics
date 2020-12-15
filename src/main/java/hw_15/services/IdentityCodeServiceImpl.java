package hw_15.services;

import hw_15.dao.IdentityCodeDao;
import hw_15.dao.IdentityCodeDaoImpl;
import hw_15.model.IdentityCode;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

public class IdentityCodeServiceImpl implements IdentityCodeService {
    Logger logger = Logger.getLogger(IdentityCodeServiceImpl.class);

    @Override
    public IdentityCode getById(int id) {
        logger.debug("IdentityCodeServiceImpl.getById(int id) method invoked with parameters: id = " + id);

        IdentityCodeDao dao = new IdentityCodeDaoImpl();
        IdentityCode identityCode = null;

        try {
            identityCode = dao.getById(id);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }

        return identityCode;
    }

    @Override
    public void save(IdentityCode identityCode) {
        logger.debug("IdentityCodeServiceImpl.save(IdentityCode identityCode) method invoked with parameters: identityCode = " + identityCode);

        if(identityCode == null) {
            logger.error("no identity code to save in the method IdentityCodeServiceImpl.save(IdentityCode identityCode): identityCode = null");
            return;
        }

        IdentityCodeDao dao = new IdentityCodeDaoImpl();

        try {
            dao.save(identityCode);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void update(IdentityCode identityCode) {
        logger.debug("IdentityCodeServiceImpl.update(IdentityCode identityCode) method invoked with parameters: identityCode = " + identityCode);

        if(identityCode == null) {
            logger.error("no identity code to update in the method IdentityCodeServiceImpl.update(IdentityCode identityCode): identityCode = null");
            return;
        }

        IdentityCodeDao dao = new IdentityCodeDaoImpl();

        try {
            dao.update(identityCode);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(IdentityCode identityCode) {
        logger.debug("IdentityCodeServiceImpl.delete(IdentityCode identityCode) method invoked with parameters: identityCode = " + identityCode);

        if(identityCode == null) {
            logger.error("no identity code to delete in the method IdentityCodeServiceImpl.delete(IdentityCode identityCode): identityCode = null");
            return;
        }

        IdentityCodeDao dao = new IdentityCodeDaoImpl();

        try {
            dao.delete(identityCode);
        } catch (HibernateException e) {
            logger.error(e.getMessage());
        }
    }
}

