package com.core.web.service;

import com.core.web.dao.GenericDao;

import java.util.List;
import java.util.Optional;

public interface ICrudService<T, ID, DAO extends GenericDao<T, ID>> {
    DAO getDao();

    default T save(final T entity) {
        return this.getDao().save(entity);
    }

    default List<T> list() {
        return this.getDao().list();
    }

    default Optional<T> find(final ID id) {
        return this.getDao().find(id);
    }

    default void delete(final T entity) {
        this.getDao().delete(entity);
    }
}
