package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.BtCommentsDao;
import io.renren.modules.sys.entity.BtCommentsEntity;
import io.renren.modules.sys.service.BtCommentsService;


@Service("btCommentsService")
public class BtCommentsServiceImpl extends ServiceImpl<BtCommentsDao, BtCommentsEntity> implements BtCommentsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BtCommentsEntity> page = this.page(
                new Query<BtCommentsEntity>().getPage(params),
                new QueryWrapper<BtCommentsEntity>()
        );

        return new PageUtils(page);
    }

}