package hw_15.dao;

import hw_15.model.IdentityCode;

public interface IdentityCodeDao {
    IdentityCode getById(int id);
    void save(IdentityCode identityCode);
    void update(IdentityCode identityCode);
    void delete(IdentityCode identityCode);
}

