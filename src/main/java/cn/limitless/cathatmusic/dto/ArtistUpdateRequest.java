package cn.limitless.cathatmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class ArtistUpdateRequest {

	@NotBlank(message = "歌手名字不能为空")
	private String name;

	private String remark;

	@NotBlank(message = "歌手照片必须上传")
	private String photoId;
}