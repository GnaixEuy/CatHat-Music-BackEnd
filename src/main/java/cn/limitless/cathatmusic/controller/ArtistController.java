package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.ArtistCreateRequest;
import cn.limitless.cathatmusic.dto.ArtistSearchFilter;
import cn.limitless.cathatmusic.dto.ArtistUpdateRequest;
import cn.limitless.cathatmusic.dto.RecommendRequest;
import cn.limitless.cathatmusic.mapper.ArtistMapper;
import cn.limitless.cathatmusic.service.ArtistService;
import cn.limitless.cathatmusic.vo.ArtistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/14
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping("/artists")
public class ArtistController {

	private ArtistService artistService;

	private ArtistMapper artistMapper;

	@PostMapping
	public ArtistVo create(@Validated @RequestBody ArtistCreateRequest artistCreateRequest) {
		return artistMapper.toVo(artistService.create(artistMapper.toDto(artistCreateRequest)));
	}

	@PostMapping("/{id}")
	public ArtistVo update(@PathVariable String id, @Validated @RequestBody ArtistUpdateRequest artistUpdateRequest) {
		return artistMapper.toVo(artistService.update(id, artistMapper.toDto(artistUpdateRequest)));
	}

	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Page<ArtistVo> search(@Validated ArtistSearchFilter artistSearchFilter) {
		return artistService.search(artistSearchFilter).map(artistMapper::toVo);
	}

	@PostMapping("/{id}/recommend")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ArtistVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
		return artistMapper.toVo(artistService.recommend(id, recommendRequest.getRecommendFactor()));
	}

	@PostMapping("/{id}/cancel_recommendation")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ArtistVo cancelRecommendation(@PathVariable String id) {
		return artistMapper.toVo(artistService.cancelRecommendation(id));
	}


	@Autowired
	public void setArtistService(ArtistService artistService) {
		this.artistService = artistService;
	}

	@Autowired
	public void setArtistMapper(ArtistMapper artistMapper) {
		this.artistMapper = artistMapper;
	}
}
