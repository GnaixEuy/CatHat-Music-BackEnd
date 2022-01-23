package cn.limitless.cathatmusic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/23
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

@RestController
@RequestMapping("/hello")
public class DefaultController {

	@RequestMapping
	public String sayHello(){
		return "欢迎来到猫猫头音乐盒Test";
	}

}
