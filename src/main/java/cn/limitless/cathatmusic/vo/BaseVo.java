package cn.limitless.cathatmusic.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/4
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public abstract class BaseVo {

	private String id;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
	private Date createdTime;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
	private Date updatedTime;

}
