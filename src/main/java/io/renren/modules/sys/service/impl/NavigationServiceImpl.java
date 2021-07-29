package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.NavigationDao;
import io.renren.modules.sys.entity.NavigationEntity;
import io.renren.modules.sys.service.NavigationService;


@Service("navigationService")
public class NavigationServiceImpl extends ServiceImpl<NavigationDao, NavigationEntity> implements NavigationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<NavigationEntity> page = this.page(
                new Query<NavigationEntity>().getPage(params),
                new QueryWrapper<NavigationEntity>()
        );

        return new PageUtils(page);
    }

}