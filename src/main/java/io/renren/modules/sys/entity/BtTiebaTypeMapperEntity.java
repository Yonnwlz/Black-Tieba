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
@TableName("bt_tieba_type_mapper")
public class BtTiebaTypeMapperEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long mapperId;
	/**
	 * 外建贴吧资源表
bt_tieba(tieba_id)
	 */
	private Long tiebaId;
	/**
	 * 外键贴吧分类
tb_tieba_type(type_id)
	 */
	private Long typeId;

}
