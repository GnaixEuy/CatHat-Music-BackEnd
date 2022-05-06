/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.*;
import cn.limitless.cathatmusic.mapper.ArtistMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.IOException;

@SpringBootTest
@Slf4j
class ArtistServiceTest extends BaseTest {

    @Autowired
    ArtistService artistService;

    @Autowired
    FileService fileService;

    @Autowired
    ArtistMapper artistMapper;

    private String photoId;


    @Test
    @WithMockUser(username = "GnaixEuy")
    void create() {
        ArtistCreateRequest artistCreateRequest = new ArtistCreateRequest();
        artistCreateRequest.setName("周杰伦");
        artistCreateRequest.setRemark("Jay Chou");
        ArtistDto artistDto = artistService.create(artistMapper.toDto(artistCreateRequest));
        Assertions.assertEquals(artistCreateRequest.getName(), artistDto.getName());
        log.info(artistDto.toString());
    }

    @BeforeEach
    public void setDefaultPhoto() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);

        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        photoId = finishedFile.getId();
    }
}