package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.*;

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
@TableName("bt_tieba")
public class BtTiebaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "tieba_id",type = IdType.AUTO)
	private Long tiebaId;
	/**
	 * 标题
	 */
	private String tiebaTitle;
	/**
	 * 外键 us_user(user_id)
	 */
	private Long tiebaUserId;
	/**
	 * 发布人
	 */
	private String tiebaUserName;
	/**
	 * 详情
	 */
	private String tiebaDesc;
	/**
	 * 贴吧图片
	 */
	private Long tiebaImageId;
	/**
	 * 资源链接
	 */
	private String tiebaLike;
	/**
	 * 提取码
	 */
	private String tiebaKey;
	/**
	 * 价格
	 */
	private Integer tiebaPrice;
	/**
	 * 热度（排序）
	 */
	private Integer tiebaHeat;

	/**
	 * 贴吧类型  1：云盘贴吧  2：图片贴吧  3：小说贴吧	4：视频贴吧
	 */
	private Integer tiebaType;

	/**
	 * 创建时间
	 */
	private Date tiebaCreateTime;
	/**
	 * 贴吧状态
0：禁用
1：可用
2：删除

	 */
	@TableLogic
	private Integer tiebaStatus;

	@TableField(exist = false)
	private String[] tiebaImages;

}
