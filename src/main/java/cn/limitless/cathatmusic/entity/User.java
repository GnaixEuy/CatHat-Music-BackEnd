package cn.limitless.cathatmusic.entity;

import cn.limitless.cathatmusic.enums.Gender;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
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

@Entity
@Table(name = "user")
@Data
public class User extends BaseEntity implements UserDetails {

	@Column(unique = true)
	private String username;

	private String nickname;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;

	private String password;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Boolean locked = false;

	private Boolean enabled = true;

	private String openId;

	private String lastLoginIp;

	private Date lastLoginTime;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
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
		return getEnabled();
	}
}