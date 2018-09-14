package com.core.web.service;

import com.core.web.model.Video;
import com.core.web.repository.VideoRepository;
import com.core.web.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    private final UserService userService;
    private final VideoRepository repository;

    @Autowired
    public VideoService(VideoRepository repository, UserService userService) {
        this.userService = userService;
        this.repository = repository;
    }

    public Video create(Video video) {
        video.setUploader(this.userService.getCurrentUser());
        return repository.save(video);
    }

    public List<Video> list() {
        return repository.findAll();
    }

    public Optional<Video> find(Integer id) {
        return repository.findById(id);
    }
}
