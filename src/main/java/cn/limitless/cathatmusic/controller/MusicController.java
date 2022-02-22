package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.MusicCreateRequest;
import cn.limitless.cathatmusic.mapper.MusicMapper;
import cn.limitless.cathatmusic.service.MusicService;
import cn.limitless.cathatmusic.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping(value = {"/musics"})
public class MusicController {

	private final MusicService musicService;
	private final MusicMapper musicMapper;

	@Autowired
	public MusicController(MusicService musicService, MusicMapper musicMapper) {
		this.musicService = musicService;
		this.musicMapper = musicMapper;
	}

	@PostMapping(value = {""})
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public MusicVo create(@RequestBody MusicCreateRequest musicCreateRequest) {
		return this.musicMapper.toVo(this.musicService.create(musicCreateRequest));
	}
}
