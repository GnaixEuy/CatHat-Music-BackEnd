package cn.limitless.cathatmusic.vo;

import cn.limitless.cathatmusic.enums.MusicStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MusicVo extends BaseVo {

	private String name;

	private MusicStatus status;

	private String description;

}
