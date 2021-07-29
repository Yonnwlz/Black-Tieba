package io.renren.modules.sys.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.UsUserDao;
import io.renren.modules.sys.entity.UsUserEntity;
import io.renren.modules.sys.service.UsUserService;


@Service("usUserService")
public class UsUserServiceImpl extends ServiceImpl<UsUserDao, UsUserEntity> implements UsUserService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UsUserEntity> page = this.page(
                new Query<UsUserEntity>().getPage(params),
                new QueryWrapper<UsUserEntity>()
        );

        return new PageUtils(page);
    }

}