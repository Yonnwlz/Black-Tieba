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
@TableName("us_level")
public class UsLevelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long levelId;
	/**
	 * 等级分数
0>	&& 100< 青铜

	 */
	private Integer levelPiecewise;
	/**
	 * 状态  
0：禁用   
1：正常
2：删除

	 */
	private String levelStatus;

}
