package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Yonnw
 * @email liaozan8888@163.com
 * @date 2021-07-15 16:01:41
 */
@Data
@TableName("bt_comments")
public class BtCommentsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long commentsId;
	/**
	 * 外键资源贴吧  bt_tieba(tieba_id)
	 */
	private Long tiebaId;
	/**
	 * 外键 用户us_user(user_id)
	 */
	private Long userId;
	/**
	 * 留言内容
	 */
	private String commentsContent;
	/**
	 * 评价时间
	 */
	private Date commentsTime;

}
