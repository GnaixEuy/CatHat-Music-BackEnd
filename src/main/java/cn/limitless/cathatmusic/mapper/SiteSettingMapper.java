package cn.limitless.cathatmusic.mapper;

import cn.limitless.cathatmusic.dto.SiteSettingDto;
import cn.limitless.cathatmusic.vo.SiteSettingVo;
import org.mapstruct.Mapper;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/5
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
	SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}
