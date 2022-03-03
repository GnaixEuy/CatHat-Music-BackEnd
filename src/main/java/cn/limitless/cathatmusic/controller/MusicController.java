package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.MusicCreateRequest;
import cn.limitless.cathatmusic.dto.MusicUpdateRequest;
import cn.limitless.cathatmusic.mapper.MusicMapper;
import cn.limitless.cathatmusic.service.MusicService;
import cn.limitless.cathatmusic.vo.MusicVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/21
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping(value = {"/musics"})
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class MusicController {

	private final MusicService musicService;
	private final MusicMapper musicMapper;

	@PostMapping(value = {""})
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public MusicVo create(@Validated @RequestBody MusicCreateRequest musicCreateRequest) {
		return this.musicMapper.toVo(this.musicService.create(musicCreateRequest));
	}

	/**
	 * 时间自动更新bug 已修复，待全面测试
	 */
	@PostMapping(value = {"/{id}"})
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public MusicVo update(@PathVariable String id, @Validated @RequestBody MusicUpdateRequest musicUpdateRequest) {
		return this.musicMapper.toVo(
				this.musicService.update(id, musicUpdateRequest));
	}

	@GetMapping(value = {""})
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public List<MusicVo> list() {
		return this.musicService.list()
				.stream()
				.map(this.musicMapper::toDto)
				.map(this.musicMapper::toVo)
				.collect(Collectors.toList());
	}

	@PostMapping(value = {"/{id}/publish"})
	public void publish(@PathVariable String id) {
		this.musicService.publish(id);
	}

	@PostMapping(value = {"/{id}/close"})
	public void close(@PathVariable String id) {
		this.musicService.close(id);
	}

}
