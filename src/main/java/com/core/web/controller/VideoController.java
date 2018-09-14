package com.core.web.controller;

import com.core.web.error.ResourceNotFoundException;
import com.core.web.model.Video;
import com.core.web.repository.VideoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.core.web.util.RouteConstants.VIDEO_API;

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
    public Video findOne(@PathVariable Integer id) { // TODO: rename to read of CRUD
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(this.getClass(), id));
    }

    /**
     * https://stackoverflow.com/a/25183266
     * @param video
     * @param cover
     * @param model
     * @return
     */
    @PostMapping
    public ResponseEntity<Video> create(@RequestPart @Valid @NotNull @NotBlank MultipartFile video,
                                        @RequestPart @Valid @NotNull @NotBlank MultipartFile cover,
                                        @RequestPart Video model) {
        // TODO: fix store video, store cover, fill model, create model
        System.out.println(video);
        System.out.println(cover);
        System.out.println(model);
        return ResponseEntity.ok().body(model);
    }
}
