package com.core.web.service.video;

import com.core.web.model.Video;
import com.core.web.dao.repository.VideoRepository;
import com.core.web.service.CrudService;
import com.core.web.service.ICrudService;
import com.core.web.service.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class VideoService extends CrudService<Video, Integer, VideoRepository> implements ICrudService<Video, Integer, VideoRepository> {
    private final UserService userService;

    public VideoService(VideoRepository repository, UserService userService) {
        super(repository);
        this.userService = userService;
    }

    public Video save(Video video) {
        video.setUploader(this.userService.getCurrentUser());
        return this.getDao().save(video);
    }
}
