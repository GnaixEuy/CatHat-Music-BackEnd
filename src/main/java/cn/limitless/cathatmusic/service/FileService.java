package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dto.FileDto;
import cn.limitless.cathatmusic.dto.FileUploadDto;
import cn.limitless.cathatmusic.dto.FileUploadRequest;
import cn.limitless.cathatmusic.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
public interface FileService extends IService<File> {

	FileUploadDto initUpload(FileUploadRequest fileUploadRequest);

	FileDto finishUpload(String id);
}
