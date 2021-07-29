package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.BtTiebaTypeMapperDao;
import io.renren.modules.sys.entity.BtTiebaTypeMapperEntity;
import io.renren.modules.sys.service.BtTiebaTypeMapperService;


@Service("btTiebaTypeMapperService")
public class BtTiebaTypeMapperServiceImpl extends ServiceImpl<BtTiebaTypeMapperDao, BtTiebaTypeMapperEntity> implements BtTiebaTypeMapperService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BtTiebaTypeMapperEntity> page = this.page(
                new Query<BtTiebaTypeMapperEntity>().getPage(params),
                new QueryWrapper<BtTiebaTypeMapperEntity>()
        );

        return new PageUtils(page);
    }

}