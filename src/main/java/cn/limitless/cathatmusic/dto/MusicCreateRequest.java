package cn.limitless.cathatmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class MusicCreateRequest {

	@NotBlank(message = "歌曲名不能为空")
	private String name;

	private String description;

}
