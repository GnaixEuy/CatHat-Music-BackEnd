/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/31
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

@Data
public class PlaylistCreateRequest {
    @NotBlank(message = "歌单名不能为空")
    private String name;

    private String description;

    @NotNull(message = "请上传封面")
    private String coverId;
}
