package cn.limitless.cathatmusic.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum FileStatus {
	/**
	 *
	 */
	UPLOADING(1, "上传中"),
	UPLOADED(2, "完成"),
	CANCEL(3, "取消");


	@EnumValue
	private Integer key;

	@JsonValue
	private String display;
}
