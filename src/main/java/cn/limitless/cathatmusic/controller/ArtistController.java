package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.ArtistCreateRequest;
import cn.limitless.cathatmusic.dto.ArtistUpdateRequest;
import cn.limitless.cathatmusic.mapper.ArtistMapper;
import cn.limitless.cathatmusic.service.ArtistService;
import cn.limitless.cathatmusic.vo.ArtistVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/14
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor(onConstructor_ = {@Lazy, @Autowired})
public class ArtistController {

	private final ArtistService artistService;

	private final ArtistMapper artistMapper;

	@PostMapping
	public ArtistVo create(@Validated @RequestBody ArtistCreateRequest artistCreateRequest) {
		return artistMapper.toVo(artistService.create(artistCreateRequest));
	}

	@PostMapping("/{id}")
	public ArtistVo update(@PathVariable String id, @Validated @RequestBody ArtistUpdateRequest artistUpdateRequest) {
		return artistMapper.toVo(artistService.update(id, artistUpdateRequest));
	}

	@GetMapping
	public List<ArtistVo> list() {
		return artistService.list().stream().map(artistMapper::toVo).collect(Collectors.toList());
	}
	
}
