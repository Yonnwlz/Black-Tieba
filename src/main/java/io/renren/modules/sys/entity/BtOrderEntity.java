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
@TableName("bt_order")
public class BtOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键  订单号
	 */
	@TableId
	private String orderOnly;
	/**
	 * 外键用户表 
us_user(user_id)
	 */
	private Long orderUserId;
	/**
	 * 用户昵称
	 */
	private String orderUserName;
	/**
	 * 外键资源贴吧bt_tieba(tieba_id)
	 */
	private Long orderTiebaId;
	/**
	 * 贴吧标题
	 */
	private String orderTiebaTitle;
	/**
	 * 虚拟币数量
	 */
	private Long orderCurrencyNumber;
	/**
	 * 订单创建时间
	 */
	private Date orderCreateTime;
	/**
	 * 状态
0：禁用
1：正常
2：删除

	 */
	private Long orderStatus;

}
