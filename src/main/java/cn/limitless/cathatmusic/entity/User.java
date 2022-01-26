package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.Gender;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString(callSuper = true)
@TableName(value = "user", resultMap = "userResultMap")
public class User extends AbstractEntity implements UserDetails {

	private String username;

	private String nickName;

	private String password;

	private Gender gender;

	private Boolean locked = false;

	private Boolean enabled = true;

	private String lastLoginIp;

	private Date lastLoginTime;

	@TableField(exist = false)
	private List<Role> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !getLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public String getNickName() {
		return nickName;
	}

	@Override
	public String getPassword() {
		return password;
	}

	public Gender getGender() {
		return gender;
	}

	public Boolean getLocked() {
		return locked;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public List<Role> getRoles() {
		return roles;
	}
}
