package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.FileUploadDto;
import cn.limitless.cathatmusic.service.StorageService;
import org.springframework.stereotype.Service;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/3
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service(value = "COS")
public class CosStorageServiceImpl implements StorageService {
	@Override
	public FileUploadDto initFileUpload() {
		return null;
	}
}
