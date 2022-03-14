package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.PlayListStatus;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "playlist", resultMap = "playListResultMap")
public class Playlist extends BaseEntity {

	private String name;

	private String description;

	private File cover;

	private PlayListStatus status;

	private User creator;

	private List<Music> musicList;

}
