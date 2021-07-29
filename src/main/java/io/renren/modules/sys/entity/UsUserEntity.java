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
@TableName("us_user")
public class UsUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long userId;
	/**
	 * 昵称
	 */
	private String userName;
	/**
	 * 肖像
	 */
	private String userPortrait;
	/**
	 * 账号
	 */
	private String userAccount;
	/**
	 * 密码
	 */
	private String userPassword;
	/**
	 * 详情
	 */
	private String userDesc;
	/**
	 * 邮箱
	 */
	private String userEmail;
	/**
	 * 状态  
0：禁用   
1：正常
2：删除
	 */
	private Integer userStatus;
	/**
	 * 等级
默认：一级 二级 ....

	 */
	private Integer userLevelId;
	/**
	 * 用户经验
	 */
	private Integer userExperience;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
