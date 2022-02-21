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
 * @date 2022/2/19
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum MusicStatus {
	/**
	 *
	 */
	DRAFT,
	PUBLISH,
	CLOSED;


	@EnumValue
	private Integer key;

	@JsonValue
	private String display;
}
