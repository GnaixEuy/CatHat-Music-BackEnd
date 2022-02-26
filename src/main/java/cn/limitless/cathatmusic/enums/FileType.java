package cn.limitless.cathatmusic.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * 文件类型枚举类
 *
 * @author GnaixEuy
 * @date 2022/2/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum FileType {
	/**
	 * 用于分辨文件类型的枚举值
	 */
	OTHER(0, "其他"),
	AUDIO(1, "音频"),
	IMAGE(2, "图像"),
	VIDEO(3, "视频");


	@EnumValue
	private Integer key;

	@JsonValue
	private String display;
}
