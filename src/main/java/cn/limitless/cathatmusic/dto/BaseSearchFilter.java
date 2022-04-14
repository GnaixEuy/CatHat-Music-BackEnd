/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.dto;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/3/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class BaseSearchFilter {
    @Min(value = 1, message = "page最小值为1")
    private Integer page = 1;

    @Min(value = 0, message = "page最小值为1")
    private Integer size = 10;


    private String direction = "desc";

    private List<String> sortBy = new ArrayList<>();

    public Pageable toPageable() {
        sortBy.add("createdTime");
        List<Sort.Order> orders = new ArrayList<>();
        for (String sort : sortBy) {
            orders.add(new Sort.Order(Sort.Direction.fromString(direction), sort));
        }
        return PageRequest.of(page - 1, size, Sort.by(orders));
    }
}