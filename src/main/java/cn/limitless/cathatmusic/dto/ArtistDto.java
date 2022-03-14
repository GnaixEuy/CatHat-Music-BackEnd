package cn.limitless.cathatmusic.dto;

import cn.limitless.cathatmusic.enums.ArtistStatus;
import lombok.*;

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
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDto extends BaseDto {
	private String name;

	private String remark;

	private FileDto photo;

	private List<MusicDto> musicDtoList;

	private ArtistStatus status;
}
