package com.core.web.service;

import com.core.web.dao.GenericDao;

public class CrudService<T, ID, DAO extends GenericDao<T, ID>> implements ICrudService<T, ID, DAO> {
    private final DAO dao;

    public CrudService(final DAO dao) {
        this.dao = dao;
    }

    @Override
    public final DAO getDao() {
        return this.dao;
    }
}
