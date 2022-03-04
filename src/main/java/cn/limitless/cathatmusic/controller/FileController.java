package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.FileUploadRequest;
import cn.limitless.cathatmusic.mapper.FileUploadMapper;
import cn.limitless.cathatmusic.service.FileService;
import cn.limitless.cathatmusic.vo.FileUploadVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RolesAllowed(value = {"ROLE_ADMIN"})
@RestController
@RequestMapping(value = {"/files"})
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class FileController {

	private final FileService fileService;
	private final FileUploadMapper fileUploadMapper;

	@PostMapping(value = {"/upload_init"})
	public FileUploadVo initUpload(@Validated @RequestBody FileUploadRequest fileUploadRequest) {
		return this.fileUploadMapper.toVo(this.fileService.initUpload(fileUploadRequest));
	}

}