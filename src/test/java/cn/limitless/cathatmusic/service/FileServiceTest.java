/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.FileDto;
import cn.limitless.cathatmusic.dto.FileUploadDto;
import cn.limitless.cathatmusic.dto.FileUploadRequest;
import cn.limitless.cathatmusic.enums.FileStatus;
import cn.limitless.cathatmusic.enums.Storage;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.IOException;

@SpringBootTest
@Slf4j
class FileServiceTest extends BaseTest {

    private FileService fileService;


    @Test
    void initUpload() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }


    @Test
    void initUploadMaxSize() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("");
        fileUploadRequest.setSize(6082813636L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
        Assertions.assertNotNull(fileUploadDto.getSecretKey());
        Assertions.assertNotNull(fileUploadDto.getSecretId());
        Assertions.assertNotNull(fileUploadDto.getSessionToken());
        Assertions.assertNotNull(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
    }

    @Test
    @WithMockUser(username = "yili")
    void finishUpload() throws IOException {
        FileUploadRequest fileUploadRequest = new FileUploadRequest();
        fileUploadRequest.setName("测试文件名");
        fileUploadRequest.setExt("mp3");
        fileUploadRequest.setKey("");
        fileUploadRequest.setSize(30000L);
        FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);

        FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
        Assertions.assertEquals(fileUploadDto.getFileId(), finishedFile.getId());
        Assertions.assertEquals(FileStatus.UPLOADED, finishedFile.getStatus());
    }


    @Test
    void getDefaultStorage() {
        Storage storage = fileService.getDefaultStorage();
        Assertions.assertEquals(Storage.COS, storage);
    }

    @Autowired
    private void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

}