package cn.limitless.cathatmusic.dto;

import cn.limitless.cathatmusic.enums.MusicStatus;
import lombok.Data;

import java.util.Date;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class MusicDto {

	private String id;

	private String name;

	private MusicStatus status;

	private String description;

	private Date createdTime;

	private Date updatedTime;
	
}
