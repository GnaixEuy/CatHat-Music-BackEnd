package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.FileDto;
import cn.limitless.cathatmusic.dto.FileUploadDto;
import cn.limitless.cathatmusic.dto.FileUploadRequest;
import cn.limitless.cathatmusic.enums.FileStatus;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/4
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
@Transactional
class FileServiceTest {

	private final FileService fileService;

	@Test
	void initUpload() throws IOException {
		final FileUploadRequest fileUploadRequest = new FileUploadRequest();
		fileUploadRequest.setName("测试文件名");
		fileUploadRequest.setExt("mp3");
		fileUploadRequest.setSize(3000L);
		fileUploadRequest.setKey("273489hfodhfsdjhfuwy098y42bfje");
		final FileUploadDto fileUploadDto = this.fileService.initUpload(fileUploadRequest);
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
		fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
		fileUploadRequest.setSize(6082813636L);
		FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
		Assertions.assertNotNull(fileUploadDto.getSecretKey());
		Assertions.assertNotNull(fileUploadDto.getSecretId());
		Assertions.assertNotNull(fileUploadDto.getSessionToken());
		Assertions.assertNotNull(fileUploadDto.getFileId());
		Assertions.assertEquals(fileUploadDto.getKey(), fileUploadRequest.getKey());
	}

	@Test
//	@WithMockUser(username = "yili")
	void finishUpload() throws IOException {
		FileUploadRequest fileUploadRequest = new FileUploadRequest();
		fileUploadRequest.setName("测试文件名");
		fileUploadRequest.setExt("mp3");
		fileUploadRequest.setKey("835741aba850778a5b06bfd57f55c98c");
		fileUploadRequest.setSize(30000L);
		FileUploadDto fileUploadDto = fileService.initUpload(fileUploadRequest);
		FileDto finishedFile = fileService.finishUpload(fileUploadDto.getFileId());
		Assertions.assertEquals(fileUploadDto.getFileId(), finishedFile.getId());
		Assertions.assertEquals(FileStatus.UPLOADED, finishedFile.getFileStatus());
	}


}