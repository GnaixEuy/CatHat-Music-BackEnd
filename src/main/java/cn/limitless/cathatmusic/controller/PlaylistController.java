package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.PlaylistCreateRequest;
import cn.limitless.cathatmusic.dto.PlaylistSearchFilter;
import cn.limitless.cathatmusic.dto.RecommendRequest;
import cn.limitless.cathatmusic.mapper.PlaylistMapper;
import cn.limitless.cathatmusic.service.PlaylistService;
import cn.limitless.cathatmusic.vo.PlaylistVo;
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

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public PlaylistVo create(@Validated @RequestBody PlaylistCreateRequest playlistCreateRequest) {
		return playlistMapper.toVo(playlistService.create(playlistMapper.toDto(playlistCreateRequest)));
	}

	@GetMapping
	public Page<PlaylistVo> search(@Validated PlaylistSearchFilter playlistSearchFilter) {
		return playlistService.search(playlistSearchFilter).map(playlistMapper::toVo);
	}


	@PostMapping("/{id}/recommend")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public PlaylistVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
		return playlistMapper.toVo(playlistService.recommend(id, recommendRequest.getRecommendFactor()));
	}

	@PostMapping("/{id}/cancel_recommendation")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public PlaylistVo cancelRecommendation(@PathVariable String id) {
		return playlistMapper.toVo(playlistService.cancelRecommendation(id));
	}

	@PostMapping("/{id}/make_special")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public PlaylistVo makeSpecial(@PathVariable String id) {
		return playlistMapper.toVo(playlistService.makeSpecial(id));
	}

	@PostMapping("/{id}/cancel_special")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public PlaylistVo cancelSpecial(@PathVariable String id) {
		return playlistMapper.toVo(playlistService.cancelSpecial(id));
	}

}