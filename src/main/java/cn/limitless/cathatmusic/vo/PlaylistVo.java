package cn.limitless.cathatmusic.vo;

import cn.limitless.cathatmusic.enums.PlayListStatus;
import lombok.*;

import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistVo extends BaseVo {

	private String name;

	private String description;

	private FileVo cover;

	private PlayListStatus status;

	private List<MusicVo> musicList;

	private Boolean recommended;

	private Integer recommendFactor;

	private Boolean special;
}