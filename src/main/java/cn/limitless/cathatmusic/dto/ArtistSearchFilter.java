package cn.limitless.cathatmusic.dto;

import lombok.Data;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class ArtistSearchFilter extends BaseSearchFilter {
	private String name = "";
}
