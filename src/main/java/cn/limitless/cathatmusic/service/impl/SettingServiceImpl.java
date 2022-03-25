package cn.limitless.cathatmusic.service.impl;

import cn.limitless.cathatmusic.dto.SiteSettingDto;
import cn.limitless.cathatmusic.service.FileService;
import cn.limitless.cathatmusic.service.SettingService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/5
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
@Data
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class SettingServiceImpl implements SettingService {

	private final FileService fileService;
	@Value("${cos.bucket}")
	private String bucket;
	@Value("${cos.region}")
	private String region;

	@Override
	public SiteSettingDto getSiteSetting() {
		SiteSettingDto siteSettingDto = new SiteSettingDto();
		siteSettingDto.setBucket(bucket);
		siteSettingDto.setRegion(region);
		siteSettingDto.setStorage(fileService.getDefaultStorage());
		return siteSettingDto;
	}
}
