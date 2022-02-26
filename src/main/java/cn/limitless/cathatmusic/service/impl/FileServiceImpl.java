package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dao.FileDao;
import cn.limitless.cathatmusic.dto.FileUploadDto;
import cn.limitless.cathatmusic.dto.FileUploadRequest;
import cn.limitless.cathatmusic.entity.File;
import cn.limitless.cathatmusic.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class FileServiceImpl extends ServiceImpl<FileDao, File> implements FileService {
	@Override
	public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) {
		return null;
	}
}
