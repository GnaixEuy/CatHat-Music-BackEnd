package cn.limitless.cathatmusic.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * <img src="http://blog.GnaixEuy.cn/wp-content/uploads/2021/08/bug.jpeg"/>
 *
 * @author GnaixEuy
 * @date 2022/1/24
 * @see <a href='https://github.com/GnaixEuy'> GnaixEuy的GitHub </a>
 */
@Data
public class AbstractEntity {

	@TableId(type = IdType.ASSIGN_UUID)
	private String id;

	@TableField(value = "created_time", fill = FieldFill.INSERT)
	private Date createdTime;

	@TableField(value = "updated_time", fill = FieldFill.INSERT_UPDATE)
	private Date updatedTime;
}
