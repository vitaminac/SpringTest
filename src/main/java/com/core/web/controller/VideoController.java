package com.core.web.controller;

import com.core.web.error.ResourceNotFoundException;
import com.core.web.model.Video;
import com.core.web.service.video.VideoService;
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

import static com.core.web.util.RouteConstants.REDIRECT;
import static com.core.web.util.RouteConstants.VIDEO_API;

@RestController
@RequestMapping(VIDEO_API)
public class VideoController {
    private final FileUploadController fileUploadRestApi;
    private final VideoService service;

    private VideoController(VideoService service, FileUploadController fileUploadRestApi) {
        this.service = service;
        this.fileUploadRestApi = fileUploadRestApi;
    }

    @GetMapping
    public List<Video> listVideos() {
        return this.service.list();
    }

    @GetMapping("{id}")
    public Video findOne(@PathVariable Integer id) { // TODO: rename to read of CRUD
        return this.service.find(id).orElseThrow(() -> new ResourceNotFoundException(this.getClass(), id));
    }

    /**
     * https://stackoverflow.com/a/25183266
     *
     * @param video
     * @param cover
     * @param model
     * @return
     */
    @PostMapping
    public ResponseEntity<Video> create(@RequestPart @Valid @NotNull @NotBlank MultipartFile video,
                                        @RequestPart @Valid @NotNull @NotBlank MultipartFile cover,
                                        @RequestPart Video model) {
        // TODO: we need to be able to delete image and video
        model.setUri(this.fileUploadRestApi.handleFileUpload(video).substring(REDIRECT.length()));
        model.setCover(this.fileUploadRestApi.handleFileUpload(cover).substring(REDIRECT.length()));
        model = this.service.save(model);
        return ResponseEntity.ok().body(model);
    }
}
