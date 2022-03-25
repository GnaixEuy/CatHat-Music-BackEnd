package cn.limitless.cathatmusic.dto;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class BaseSearchFilter {
	@Min(value = 1, message = "page最小值为1")
	private Integer page = 1;

	@Min(value = 0, message = "page最小值为1")
	private Integer size = 10;
}