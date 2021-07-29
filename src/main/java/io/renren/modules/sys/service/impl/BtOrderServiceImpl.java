package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.BtOrderDao;
import io.renren.modules.sys.entity.BtOrderEntity;
import io.renren.modules.sys.service.BtOrderService;


@Service("btOrderService")
public class BtOrderServiceImpl extends ServiceImpl<BtOrderDao, BtOrderEntity> implements BtOrderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BtOrderEntity> page = this.page(
                new Query<BtOrderEntity>().getPage(params),
                new QueryWrapper<BtOrderEntity>()
        );

        return new PageUtils(page);
    }

}