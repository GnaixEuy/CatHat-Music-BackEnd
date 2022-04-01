package cn.limitless.cathatmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/31
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

@Data
public class PlaylistCreateRequest {
	@NotBlank(message = "歌单名不能为空")
	private String name;

	private String description;

	@NotNull(message = "请上传封面")
	private String coverId;
}
