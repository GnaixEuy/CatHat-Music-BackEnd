package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.MusicCreateRequest;
import cn.limitless.cathatmusic.dto.MusicSearchFilter;
import cn.limitless.cathatmusic.dto.MusicUpdateRequest;
import cn.limitless.cathatmusic.mapper.MusicMapper;
import cn.limitless.cathatmusic.service.MusicService;
import cn.limitless.cathatmusic.vo.MusicVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public MusicVo create(@Validated @RequestBody MusicCreateRequest musicCreateRequest) {
		return musicMapper.toVo(musicService.create(musicMapper.toDto(musicCreateRequest)));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public MusicVo update(@PathVariable String id, @Validated @RequestBody MusicUpdateRequest musicUpdateRequest) {
		return musicMapper.toVo(musicService.update(id, musicMapper.toDto(musicUpdateRequest)));
	}


	// Todo: post请求; 参数问题
	@PostMapping("/search")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Page<MusicVo> search(@RequestBody(required = false) MusicSearchFilter searchFilter) {
		return musicService.search(searchFilter).map(musicMapper::toVo);
	}

	@PostMapping("/{id}/publish")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void publish(@PathVariable String id) {
		musicService.publish(id);
	}

	@PostMapping("/{id}/close")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void close(@PathVariable String id) {
		musicService.close(id);
	}
}
