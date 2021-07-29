package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.UsCurrencyDao;
import io.renren.modules.sys.entity.UsCurrencyEntity;
import io.renren.modules.sys.service.UsCurrencyService;


@Service("usCurrencyService")
public class UsCurrencyServiceImpl extends ServiceImpl<UsCurrencyDao, UsCurrencyEntity> implements UsCurrencyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsCurrencyEntity> page = this.page(
                new Query<UsCurrencyEntity>().getPage(params),
                new QueryWrapper<UsCurrencyEntity>()
        );

        return new PageUtils(page);
    }

}