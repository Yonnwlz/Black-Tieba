package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.BtTiebaEntity;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 *
 * @author Yonnw
 * @email liaozan8888@163.com
 * @date 2021-07-15 16:01:41
 */
public interface BtTiebaService extends IService<BtTiebaEntity> {

    PageUtils queryPage(Map<String, Object> params,Integer tiebaTypeId);

    Boolean saveTieba(BtTiebaEntity btTieba);

    Boolean updateTiebaById(BtTiebaEntity btTieba);

    BtTiebaEntity getTieBaById(Serializable id);

    /**
     * description 下架贴吧（被删除贴吧）
     * param [parmas, tiebaStatus]
     * return io.renren.common.utils.PageUtils
     * author Yonnw丶
     * createTime 2021/7/26 14:48
     */
    PageUtils getTiebaStatus(Map<String, Object> parmas, Integer tiebaStatus);
}

