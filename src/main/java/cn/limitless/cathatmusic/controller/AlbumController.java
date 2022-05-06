/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.AlbumCreateRequest;
import cn.limitless.cathatmusic.dto.AlbumSearchFilter;
import cn.limitless.cathatmusic.dto.AlbumUpdateRequest;
import cn.limitless.cathatmusic.dto.RecommendRequest;
import cn.limitless.cathatmusic.mapper.AlbumMapper;
import cn.limitless.cathatmusic.service.AlbumService;
import cn.limitless.cathatmusic.vo.AlbumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 * <p>
 * 项目： CatHat-Music
 *
 * @author GnaixEuy
 * @date 2022/5/6
 * @see <a href="https://github.com/GnaixEuy"> GnaixEuy的GitHub </a>
 */

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private AlbumService albumService;

    private AlbumMapper albumMapper;

    @PostMapping
    public AlbumVo create(@Validated @RequestBody AlbumCreateRequest albumCreateRequest) {
        return albumMapper.toVo(albumService.create(albumMapper.toDto(albumCreateRequest)));
    }

    @PostMapping("/{id}")
    public AlbumVo update(@PathVariable String id, @Validated @RequestBody AlbumUpdateRequest albumUpdateRequest) {
        return albumMapper.toVo(albumService.update(id, albumMapper.toDto(albumUpdateRequest)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        albumService.delete(id);
    }

    @GetMapping
    public Page<AlbumVo> search(@Validated AlbumSearchFilter albumSearchFilter) {
        return albumService.search(albumSearchFilter).map(albumMapper::toVo);
    }

    @PostMapping("/{id}/recommend")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AlbumVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
        return albumMapper.toVo(albumService.recommend(id, recommendRequest.getRecommendFactor()));
    }

    @PostMapping("/{id}/cancel_recommendation")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AlbumVo cancelRecommendation(@PathVariable String id) {
        return albumMapper.toVo(albumService.cancelRecommendation(id));
    }

    @Autowired
    public void setAlbumMapper(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }
}
