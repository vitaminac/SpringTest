package com.core.web.controller;

import com.core.web.model.Video;
import com.core.web.repository.VideoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.core.web.util.PathMappingConstants.VIDEO_API;

@RestController
@RequestMapping(VIDEO_API)
public class VideoController {
    private final VideoRepository repository;

    VideoController(VideoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Video> listVideos() {
        return this.repository.findAll();
    }

    @GetMapping("{id}")
    public Video findOne(@PathVariable Integer id) {
        return this.repository.findById(id).get(); // TODO: fix;
    }
}
