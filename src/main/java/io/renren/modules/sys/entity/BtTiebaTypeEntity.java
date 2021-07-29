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
@TableName("bt_tieba_type")
public class BtTiebaTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId(value = "type_id",type = IdType.AUTO)
	private Long typeId;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 贴吧类型  1：云盘贴吧  2：图片贴吧  3：小说贴吧	4：视频贴吧
	 */
	private Integer tiebaType;
	/**
	 * 排序
	 */
	private Integer typeSort;

}
