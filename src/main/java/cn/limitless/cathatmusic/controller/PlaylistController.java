/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.controller;

import cn.limitless.cathatmusic.dto.PlaylistCreateRequest;
import cn.limitless.cathatmusic.dto.PlaylistSearchFilter;
import cn.limitless.cathatmusic.dto.RecommendRequest;
import cn.limitless.cathatmusic.mapper.PlaylistMapper;
import cn.limitless.cathatmusic.service.PlaylistService;
import cn.limitless.cathatmusic.vo.PlaylistVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/12
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private PlaylistService playlistService;

    private PlaylistMapper playlistMapper;


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

    @Autowired
    @Lazy
    public void setPlaylistService(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Autowired
    @Lazy
    public void setPlaylistMapper(PlaylistMapper playlistMapper) {
        this.playlistMapper = playlistMapper;
    }
}