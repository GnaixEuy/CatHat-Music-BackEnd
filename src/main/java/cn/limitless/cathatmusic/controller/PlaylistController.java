package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.mapper.PlaylistMapper;
import cn.limitless.cathatmusic.service.PlaylistService;
import cn.limitless.cathatmusic.vo.PlaylistVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping("/playlists")
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class PlaylistController {

	private final PlaylistService playlistService;

	private final PlaylistMapper playlistMapper;


	@GetMapping("/{id}")
	public PlaylistVo get(@PathVariable String id) {
		return playlistMapper.toVo(playlistService.get(id));
	}
}