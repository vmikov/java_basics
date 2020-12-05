package hw_15.services;

import hw_15.dao.IdentityCodeDao;
import hw_15.dao.IdentityCodeDaoImpl;
import hw_15.model.IdentityCode;

public class IdentityCodeServiceImpl implements IdentityCodeService {
    @Override
    public IdentityCode getById(int id) {
        IdentityCodeDao dao = new IdentityCodeDaoImpl();

        return dao.getById(id);
    }

    @Override
    public void save(IdentityCode identityCode) {
        if(identityCode == null) {
            System.out.println("IdentityCode is null");
            return;
        }

        IdentityCodeDao dao = new IdentityCodeDaoImpl();
        dao.save(identityCode);
    }

    @Override
    public void update(IdentityCode identityCode) {
        if(identityCode == null) {
            System.out.println("IdentityCode is null");
            return;
        }

        IdentityCodeDao dao = new IdentityCodeDaoImpl();
        dao.update(identityCode);
    }

    @Override
    public void delete(IdentityCode identityCode) {
        if(identityCode == null) {
            System.out.println("IdentityCode is null");
            return;
        }

        IdentityCodeDao dao = new IdentityCodeDaoImpl();
        dao.delete(identityCode);
    }
}

