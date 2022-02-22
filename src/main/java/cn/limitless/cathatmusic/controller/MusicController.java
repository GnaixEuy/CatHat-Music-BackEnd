package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.MusicCreateRequest;
import cn.limitless.cathatmusic.dto.MusicUpdateRequest;
import cn.limitless.cathatmusic.mapper.MusicMapper;
import cn.limitless.cathatmusic.service.MusicService;
import cn.limitless.cathatmusic.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
	public MusicVo create(@Validated @RequestBody MusicCreateRequest musicCreateRequest) {
		return this.musicMapper.toVo(this.musicService.create(musicCreateRequest));
	}

	/**
	 * Todo 自动更新时间bug未修复
	 */
	@PostMapping(value = {"/{id}"})
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public MusicVo update(@PathVariable String id, @Validated @RequestBody MusicUpdateRequest musicUpdateRequest) {
		return this.musicMapper.toVo(
				this.musicService.update(id, musicUpdateRequest));
	}
}
