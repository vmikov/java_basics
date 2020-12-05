package hw_15.services;

import hw_15.model.IdentityCode;

public interface IdentityCodeService {
    IdentityCode getById(int id);
    void save(IdentityCode identityCode);
    void update(IdentityCode identityCode);
    void delete(IdentityCode identityCode);
}

