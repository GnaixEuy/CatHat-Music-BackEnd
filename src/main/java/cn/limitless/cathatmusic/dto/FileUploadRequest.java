package cn.limitless.cathatmusic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadRequest {

	@NotBlank(message = "文件名不能为空")
	private String name;

	private Integer size;

	@NotBlank(message = "后缀名不能为空")
	private String ext;

	@NotBlank(message = "key不能为空")
	private String key;


}
