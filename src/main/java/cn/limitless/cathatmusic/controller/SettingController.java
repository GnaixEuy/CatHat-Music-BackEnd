package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.mapper.SiteSettingMapper;
import cn.limitless.cathatmusic.service.SettingService;
import cn.limitless.cathatmusic.vo.SiteSettingVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/5
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping("/settings")
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class SettingController {

	private final SettingService settingService;

	private final SiteSettingMapper siteSettingMapper;

	@GetMapping("/site")
	public SiteSettingVo getSiteSetting() {
		return siteSettingMapper.toVo(settingService.getSiteSetting());
	}

}
