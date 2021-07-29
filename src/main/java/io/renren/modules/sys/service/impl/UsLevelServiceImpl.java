package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.UsLevelDao;
import io.renren.modules.sys.entity.UsLevelEntity;
import io.renren.modules.sys.service.UsLevelService;


@Service("usLevelService")
public class UsLevelServiceImpl extends ServiceImpl<UsLevelDao, UsLevelEntity> implements UsLevelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsLevelEntity> page = this.page(
                new Query<UsLevelEntity>().getPage(params),
                new QueryWrapper<UsLevelEntity>()
        );

        return new PageUtils(page);
    }

}