package cn.limitless.cathatmusic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/25
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user_role")
public class UserRoleRelation {

	@TableField(value = "user_id")
	private String userId;
	@TableField(value = "role_id")
	private String roleId;
}
