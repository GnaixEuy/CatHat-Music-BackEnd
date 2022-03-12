package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.MusicStatus;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/19
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "music", resultMap = "musicResultMap")
public class Music extends BaseEntity {

	private String name;

	private MusicStatus status;

	private String description;

	/**
	 * @Description: TODO: 需要持久层一对一对象映射
	 */
	private File file;
}
