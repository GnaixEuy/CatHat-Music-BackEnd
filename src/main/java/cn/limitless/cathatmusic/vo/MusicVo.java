package cn.limitless.cathatmusic.vo;

import cn.limitless.cathatmusic.enums.MusicStatus;
import lombok.*;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicVo extends BaseVo {

	private String name;

	private MusicStatus status;

	private String description;

	private FileVo file;

	private List<ArtistVo> artistList;
}
