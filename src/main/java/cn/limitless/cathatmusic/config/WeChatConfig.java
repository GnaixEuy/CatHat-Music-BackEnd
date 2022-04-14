/*
 * Copyright (c) 2022. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package cn.limitless.cathatmusic.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/14
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Configuration
public class WeChatConfig {

    @Value(value = "${weixin.mp.app.id}")
    private String appId;

    @Value(value = "${weixin.mp.app.secret}")
    private String appSecret;

    @Bean
    public WxMpService wxMpService() {
        final WxMpService wxMpService = new WxMpServiceImpl();
        final WxMpDefaultConfigImpl wxMpDefaultConfig = new WxMpDefaultConfigImpl();
        wxMpDefaultConfig.setAppId(this.appId);
        wxMpDefaultConfig.setSecret(this.appSecret);
        wxMpService.setWxMpConfigStorage(wxMpDefaultConfig);
        return wxMpService;
    }
}
