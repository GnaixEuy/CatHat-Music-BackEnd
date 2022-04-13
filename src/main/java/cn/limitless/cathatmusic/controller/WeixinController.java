package cn.limitless.cathatmusic.controller;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * <img src="https://c-ssl.duitang.com/uploads/blog/202008/30/20200830183701_3ZzSR.thumb.1000_0.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/2/14
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@RestController
@RequestMapping(value = {"/weixin"})
public class WeixinController {

    private WxMpService wxMpService;

    @GetMapping("/auth_url")
    public String getAuthUrl(@PathParam("redirectUrl") String redirectUrl) {
        return wxMpService.getOAuth2Service().buildAuthorizationUrl(
                redirectUrl,
                WxConsts.OAuth2Scope.SNSAPI_USERINFO,
                null
        );
    }

    @Autowired
    @Lazy
    public void setWxMpService(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }
}
