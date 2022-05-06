/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.*;
import cn.limitless.cathatmusic.enums.MusicStatus;
import cn.limitless.cathatmusic.mapper.ArtistMapper;
import cn.limitless.cathatmusic.mapper.MusicMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class MusicServiceTest extends BaseTest {

    @Autowired
    MusicService musicService;

    @Autowired
    MusicMapper musicMapper;

    @Autowired
    FileService fileService;

    @Autowired
    ArtistService artistService;

    @Autowired
    ArtistMapper artistMapper;

    String fileId;

    List<String> artistIds = new ArrayList<>();

    @Test
    @WithMockUser(username = "yili")
    void create() {
        MusicCreateRequest musicCreateRequest = new MusicCreateRequest();
        musicCreateRequest.setName("夜曲");
        musicCreateRequest.setFileId(fileId);
        musicCreateRequest.setArtistIds(artistIds);
        MusicDto savedMusicDto = musicService.create(musicMapper.toDto(musicCreateRequest));
        Assertions.assertEquals(musicCreateRequest.getName(), savedMusicDto.getName());
        Assertions.assertEquals(musicCreateRequest.getDescription(), savedMusicDto.getDescription());
        Assertions.assertEquals(MusicStatus.DRAFT, savedMusicDto.getStatus());
        Assertions.assertEquals(musicCreateRequest.getFileId(), savedMusicDto.getFile().getId());
        Assertions.assertEquals(
                musicCreateRequest.getArtistIds(),
                savedMusicDto.getArtistList().stream().map(BaseDto::getId).collect(Collectors.toList()));
        log.info(savedMusicDto.toString());
    }

    @BeforeEach
    public void setDefaultFileId() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        fileId = finishedFile.getId();
    }

    @BeforeEach
    public void setDefaultArtistIds() {
        ArtistCreateRequest artistCreateRequest = new ArtistCreateRequest();
        artistCreateRequest.setName("周杰伦");
        artistCreateRequest.setPhotoId(fileId);
        ArtistDto artistDto = artistService.create(artistMapper.toDto(artistCreateRequest));
        artistIds.add(artistDto.getId());
    }


    @Test
    void publish() {
    }

    @Test
    void close() {
    }
}