package com.core.web.dao.repository;

import com.core.web.dao.SpringJpaRepositoryDao;
import com.core.web.model.Resource;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends SpringJpaRepositoryDao<Resource, Integer> {
}
