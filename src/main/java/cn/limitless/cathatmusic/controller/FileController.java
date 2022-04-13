package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.FileUploadRequest;
import cn.limitless.cathatmusic.mapper.FileMapper;
import cn.limitless.cathatmusic.mapper.FileUploadMapper;
import cn.limitless.cathatmusic.service.FileService;
import cn.limitless.cathatmusic.vo.FileUploadVo;
import cn.limitless.cathatmusic.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.io.IOException;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RolesAllowed(value = {"ROLE_ADMIN"})
@RequestMapping(value = {"/files"})
public class FileController {

    private FileService fileService;

    private FileMapper fileMapper;

    private FileUploadMapper fileUploadMapper;

    @PostMapping("/upload_init")
    public FileUploadVo initUpload(@Validated @RequestBody FileUploadRequest fileUploadRequest) throws IOException {
        return fileUploadMapper.toVo(fileService.initUpload(fileUploadRequest));
    }

    @PostMapping("/{id}/upload_finish")
    public FileVo finishUpload(@PathVariable String id) {
        return fileMapper.toVo(fileService.finishUpload(id));
    }

    @Autowired
    @Lazy
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    @Lazy
    public void setFileMapper(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @Autowired
    @Lazy
    public void setFileUploadMapper(FileUploadMapper fileUploadMapper) {
        this.fileUploadMapper = fileUploadMapper;
    }
}
