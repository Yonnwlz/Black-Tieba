package io.renren.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.utils.RedisUtils;
import io.renren.modules.sys.entity.BtTiebaImageEntity;
import io.renren.modules.sys.service.BtTiebaImageService;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.sql.Wrapper;
import java.text.SimpleDateFormat;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.nodules.dao.BtTiebaDao;
import io.renren.modules.sys.entity.BtTiebaEntity;
import io.renren.modules.sys.service.BtTiebaService;
import org.springframework.transaction.annotation.Transactional;


@Service("btTiebaService")
public class BtTiebaServiceImpl extends ServiceImpl<BtTiebaDao, BtTiebaEntity> implements BtTiebaService {

    @Autowired
    private BtTiebaImageService btTiebaImageService;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public PageUtils queryPage(Map<String, Object> params,Integer tiebaTypeId) {
        IPage<BtTiebaEntity> page = this.page(
                new Query<BtTiebaEntity>().getPage(params),
                new QueryWrapper<BtTiebaEntity>().eq("tieba_type",tiebaTypeId)
        );
        //展示图查询
        for (BtTiebaEntity item : page.getRecords()) {
            try {
                List<BtTiebaImageEntity> bytiebaList = btTiebaImageService.getBytiebaId(Long.valueOf(item.getTiebaId()));
                bytiebaList.forEach((btTiebaImageEntity -> {
                    if(btTiebaImageEntity !=null){
                        String imageurl[] = new String [1];
                        imageurl[0] = btTiebaImageEntity.getImageUrl();
                        item.setTiebaImages(imageurl);
                        throw new RuntimeException();
                    }
                }));
            }catch (Exception e){}
        }
        //存入缓存中
        List<BtTiebaEntity> records = page.getRecords();
        redisUtils.set("TiebaAll", JSON.toJSONString(records));

        return new PageUtils(page);
    }

    @Override
    @Transactional
    public Boolean saveTieba(BtTiebaEntity btTieba) {
        btTieba.setTiebaCreateTime(new Date());
        save(btTieba);
        //贴吧图片保存
        for (String tiebaImage : btTieba.getTiebaImages()) {
            BtTiebaImageEntity btTiebaImageEntity = new BtTiebaImageEntity();
            btTiebaImageEntity.setTiebaId(btTieba.getTiebaId());
            btTiebaImageEntity.setImageUrl(tiebaImage);
            btTiebaImageEntity.setImageSort(0);
            btTiebaImageEntity.setImageStatus(0);
            btTiebaImageService.save(btTiebaImageEntity);
        }
        return true;
    }

    @Override
    public Boolean updateTiebaById(BtTiebaEntity btTieba) {
        //删除原有图片
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("tieba_id",btTieba.getTiebaId());
        btTiebaImageService.removeByMap(columnMap);
        //贴吧图片保存
        for(String url :btTieba.getTiebaImages()){
            BtTiebaImageEntity btTiebaImageEntity = new BtTiebaImageEntity();
            btTiebaImageEntity.setTiebaId(btTieba.getTiebaId());
            btTiebaImageEntity.setImageUrl(url);
            btTiebaImageEntity.setImageSort(0);
            btTiebaImageEntity.setImageStatus(0);
            btTiebaImageService.save(btTiebaImageEntity);
        }
        return true;
    }

    @Override
    public BtTiebaEntity getTieBaById(Serializable id) {
        List<String> urls = new ArrayList<String>();
        BtTiebaEntity btTiebaEntity = baseMapper.selectById(id);
        //图片查询
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("tieba_id",btTiebaEntity.getTiebaId());
        List<BtTiebaImageEntity> btTiebaImageEntities = btTiebaImageService.listByMap(columnMap);
        for(int i=0;i<btTiebaImageEntities.size();i++){
            urls.add(btTiebaImageEntities.get(i).getImageUrl());
        }
        String[] array = (String[])urls.toArray(new String[urls.size()]);
        btTiebaEntity.setTiebaImages(array);
        return btTiebaEntity;
    }

    @Override
    public PageUtils getTiebaStatus(Map<String, Object> parmas, Integer tiebaStatus) {
            IPage<BtTiebaEntity> tieba_status = this.page(new Query<BtTiebaEntity>().getPage(parmas), new QueryWrapper<BtTiebaEntity>().eq("tieba_status",tiebaStatus));
        return new PageUtils(tieba_status);
    }


}