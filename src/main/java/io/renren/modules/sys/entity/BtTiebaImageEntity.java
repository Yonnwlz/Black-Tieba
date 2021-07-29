package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * 
 * @author Yonnw
 * @email liaozan8888@163.com
 * @date 2021-07-15 16:01:41
 */
@Data
@TableName("bt_tieba_image")
public class BtTiebaImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "image_id",type = IdType.AUTO)
	private Long imageId;

	/**
	 * 外建bt_tieba(tieba_id)
	 */
	private Long tiebaId;

	/**
	 * 图片贴吧
	 */
	@TableField(exist = false)
	private String tiebaName;

	/**
	 * 图片地址
	 */
	private String imageUrl;
	/**
	 * 状态
0：禁用
1：正常
2：删除

	 */
	private Integer imageStatus;

	/**
	 * 贴吧类型  1：云盘贴吧  2：图片贴吧  3：小说贴吧	4：视频贴吧
	 */
	private Integer tiebaType;

	/**
	 * 排序
	 */
	private Integer imageSort;

}
