package io.renren.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import io.renren.common.utils.RedisUtils;
import io.renren.modules.sys.entity.BtTiebaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.BtTiebaImageDao;
import io.renren.modules.sys.entity.BtTiebaImageEntity;
import io.renren.modules.sys.service.BtTiebaImageService;


@Service("btTiebaImageService")
public class BtTiebaImageServiceImpl extends ServiceImpl<BtTiebaImageDao, BtTiebaImageEntity> implements BtTiebaImageService {

    @Autowired
    private RedisUtils redisUtils;


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BtTiebaImageEntity> page = this.page(
                new Query<BtTiebaImageEntity>().getPage(params),
                new QueryWrapper<BtTiebaImageEntity>()
        );

       page.getRecords().forEach((item->{
            //获取缓存资源
           List<BtTiebaEntity> tiebaAll = JSON.parseArray(redisUtils.get("TiebaAll"), BtTiebaEntity.class);
           tiebaAll.forEach((btTiebaEntity -> {
               if(item.getTiebaId() == btTiebaEntity.getTiebaId()){
                   item.setTiebaName(btTiebaEntity.getTiebaTitle());
               }
           }));
        }));
        return new PageUtils(page);
    }

    @Override
    public List<BtTiebaImageEntity> getBytiebaId(Long tiebaId) {
        QueryWrapper<BtTiebaImageEntity> entityQueryWrapper = new QueryWrapper<>();
        entityQueryWrapper.eq("tieba_id",tiebaId);
        List<BtTiebaImageEntity> list = list(entityQueryWrapper);
        return list;
    }

}