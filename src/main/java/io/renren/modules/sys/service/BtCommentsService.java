package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.BtCommentsEntity;

import java.util.Map;

/**
 * 
 *
 * @author Yonnw
 * @email liaozan8888@163.com
 * @date 2021-07-15 16:01:41
 */
public interface BtCommentsService extends IService<BtCommentsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

