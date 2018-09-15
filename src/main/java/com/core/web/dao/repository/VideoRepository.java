package com.core.web.dao.repository;

import com.core.web.dao.SpringJpaRepositoryDao;
import com.core.web.model.Video;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends SpringJpaRepositoryDao<Video, Integer> {
}
