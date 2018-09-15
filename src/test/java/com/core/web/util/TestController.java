package com.core.web.util;

import com.core.web.dao.repository.ResourceRepository;
import com.core.web.dao.repository.UserRepository;
import com.core.web.dao.repository.VideoRepository;
import com.core.web.model.Video;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TestController {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private UserRepository userRepository;

    private Video video;

    @Before
    public void setUp() throws Exception {
        video = new Video();
        video.setName("test");
        video.setCover("test");
        video.setUri("test");
        video.setUploader(userRepository.findById("demo").get());
        this.video = videoRepository.save(this.video);
        assertTrue(videoRepository.findById(video.getId()).isPresent());
        assertTrue(resourceRepository.findById(video.getId()).isPresent());
    }

    @After
    public void tearDown() throws Exception {
        assertFalse(videoRepository.findById(video.getId()).isPresent());
        assertFalse(resourceRepository.findById(video.getId()).isPresent());
    }

    @Test
    public void testDeleteChild() {
        videoRepository.delete(this.video);
    }

    @Test
    public void testDeleteParent() {
        resourceRepository.delete(this.video);
    }
}
