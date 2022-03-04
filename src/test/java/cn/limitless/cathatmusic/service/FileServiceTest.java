package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.FileUploadRequest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/4
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
class FileServiceTest {

	private final FileService fileService;

	@Test
	void initUpload() {
		final FileUploadRequest fileUploadRequest = new FileUploadRequest();
		fileUploadRequest.setName("测试文件名");
		fileUploadRequest.setExt("mp3");
		fileUploadRequest.setSize(3000);
		fileUploadRequest.setKey("273489hfodhfsdjhfuwy098y42bfje");
		this.fileService.initUpload(fileUploadRequest);
	}

}