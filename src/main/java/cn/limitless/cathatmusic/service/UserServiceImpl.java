package cn.limitless.cathatmusic.service;

import cn.limitless.cathatmusic.dao.RoleDao;
import cn.limitless.cathatmusic.dao.UserDao;
import cn.limitless.cathatmusic.dao.UserRoleRelationDao;
import cn.limitless.cathatmusic.dto.UserDto;
import cn.limitless.cathatmusic.entity.Role;
import cn.limitless.cathatmusic.entity.User;
import cn.limitless.cathatmusic.entity.UserRoleRelation;
import cn.limitless.cathatmusic.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

	private final UserRoleRelationDao userRoleRelationDao;
	private final RoleDao roleDao;
	private final UserDao userDao;
	private final UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserDao userDao, UserMapper userMapper, RoleDao roleDao, UserRoleRelationDao userRoleRelationDao) {
		this.userDao = userDao;
		this.userMapper = userMapper;
		this.roleDao = roleDao;
		this.userRoleRelationDao = userRoleRelationDao;
	}

	@Override
	public List<UserDto> getList() {
		final List<User> list = super.list();
		ArrayList<Role> roles;
		final HashMap<String, Object> conditionMap = new HashMap<>(1);
		for (User user : list) {
			conditionMap.put("user_id", user.getId());
			List<UserRoleRelation> userRoleRelationList = this.userRoleRelationDao.selectByMap(conditionMap);
			roles = new ArrayList<>();
			for (UserRoleRelation userRoleRelation : userRoleRelationList) {
				final Role role = this.roleDao.selectById(userRoleRelation.getRoleId());
				if (!roles.add(role)) {
					try {
						throw new Exception("填充身份错误");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			user.setRoles(roles);
		}
		return list.stream().map(userMapper::toDto).collect(Collectors.toList());
	}
}
