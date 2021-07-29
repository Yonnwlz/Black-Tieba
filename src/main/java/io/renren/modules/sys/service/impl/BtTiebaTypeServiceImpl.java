package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.BtTiebaTypeDao;
import io.renren.modules.sys.entity.BtTiebaTypeEntity;
import io.renren.modules.sys.service.BtTiebaTypeService;


@Service("btTiebaTypeService")
public class BtTiebaTypeServiceImpl extends ServiceImpl<BtTiebaTypeDao, BtTiebaTypeEntity> implements BtTiebaTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params,Integer tiebaTypeId) {
        IPage<BtTiebaTypeEntity> page = this.page(
                new Query<BtTiebaTypeEntity>().getPage(params),
                new QueryWrapper<BtTiebaTypeEntity>().eq("tieba_type",tiebaTypeId)
        );

        return new PageUtils(page);
    }

}