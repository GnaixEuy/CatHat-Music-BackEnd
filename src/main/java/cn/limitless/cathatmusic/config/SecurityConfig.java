package cn.limitless.cathatmusic.config;

import cn.limitless.cathatmusic.exception.RestAuthenticationEntryPoint;
import cn.limitless.cathatmusic.filter.JwtAuthorizationFilter;
import cn.limitless.cathatmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/26
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		prePostEnabled = true,
		securedEnabled = true,
		jsr250Enabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String SECRET = "CatHatMusic";
	/**
	 * 1 days
	 */
	public static final long EXPIRATION_TIME = 86400000;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String CREATE_TOKEN_URL = "/tokens/**";
	public static final String SITE_SETTING_URL = "/settings/site";

	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	private UserService userService;


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.authorizeRequests()
				.antMatchers(SecurityConfig.CREATE_TOKEN_URL).permitAll()
				.antMatchers(SecurityConfig.SITE_SETTING_URL).permitAll()
				.antMatchers("/playlists/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userService))
				.exceptionHandling()
				.authenticationEntryPoint(this.restAuthenticationEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userService);
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setRestAuthenticationEntryPoint(RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
		this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/swagger**/**")
				.antMatchers("/webjars/**")
				.antMatchers("/v3/**")
				.antMatchers("/doc.html")
				.antMatchers("/weixin/**");
	}
}
