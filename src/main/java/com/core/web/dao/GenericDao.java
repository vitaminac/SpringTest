package com.core.web.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID> {
    <D extends T> D save(D entity);

    List<T> list();

    Optional<T> find(ID id);

    void delete(T entity);
}
