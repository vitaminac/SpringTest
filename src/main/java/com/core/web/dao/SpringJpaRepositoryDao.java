package com.core.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface SpringJpaRepositoryDao<T, ID> extends GenericDao<T, ID>, JpaRepository<T, ID> {
    default List<T> list() {
        return this.findAll();
    }

    default Optional<T> find(ID id) {
        return this.findById(id);
    }
}
