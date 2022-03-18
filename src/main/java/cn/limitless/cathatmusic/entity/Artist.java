package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.ArtistStatus;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/13
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@TableName(value = "artist", resultMap = "artistResultMap")
public class Artist extends TraceableBaseEntity {

	private String name;

	private String remark;

	private File photo;

	private List<Music> musicList;

	private ArtistStatus status;

}
