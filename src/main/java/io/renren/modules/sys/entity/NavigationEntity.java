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
@TableName("navigation")
public class NavigationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Long naviId;
	/**
	 * 父id
	 */
	private Long naviParentId;
	/**
	 * 导航名称
	 */
	private String naviName;
	/**
	 * url地址
	 */
	private String naviUrl;
	/**
	 * 排序
	 */
	private Integer naviSort;

}
