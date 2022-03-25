package cn.limitless.cathatmusic.dto;

import cn.limitless.cathatmusic.enums.MusicStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
public class MusicDto extends BaseDto {

	private String name;

	private MusicStatus status = MusicStatus.DRAFT;

	private String description;

	private FileDto file;

	private List<ArtistDto> artistList;

}
