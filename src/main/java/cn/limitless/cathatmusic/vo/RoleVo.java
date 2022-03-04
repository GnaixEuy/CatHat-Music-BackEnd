package cn.limitless.cathatmusic.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RoleVo extends BaseVo {

	private String id;

	private String name;

	private String title;
}
