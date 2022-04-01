package cn.limitless.cathatmusic.dto;

import cn.limitless.cathatmusic.enums.PlayListStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDto extends TraceableBaseDto {

	private String name;

	private String description;

	private FileDto cover;

	private PlayListStatus status;

	private List<MusicDto> musicList;

	private Boolean recommended;

	private Integer recommendFactor;

	private Boolean special;
}
