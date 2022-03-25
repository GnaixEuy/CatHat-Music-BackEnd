package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.FileUploadDto;

import java.io.IOException;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/3
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface StorageService {
	FileUploadDto initFileUpload() throws IOException;

	String getFileUri(String fileKey);
}
