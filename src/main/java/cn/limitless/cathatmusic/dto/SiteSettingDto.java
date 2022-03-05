package cn.limitless.cathatmusic.dto;

import cn.limitless.cathatmusic.enums.Storage;
import lombok.Data;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/5
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class SiteSettingDto {

	private String bucket;

	private String region;

	private Storage storage;
}
