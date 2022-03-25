package cn.limitless.cathatmusic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/22
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicUpdateRequest {

	@NotBlank(message = "歌曲名不能为空")
	private String name;

	private String description;

	private String fileId;

	@NotNull(message = "歌手未选择")
	private List<String> artistIds;
}
