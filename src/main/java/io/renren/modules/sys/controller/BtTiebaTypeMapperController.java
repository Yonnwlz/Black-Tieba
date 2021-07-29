package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.BtTiebaTypeMapperEntity;
import io.renren.modules.sys.service.BtTiebaTypeMapperService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author Yonnw
 * @email liaozan8888@163.com
 * @date 2021-07-15 16:01:41
 */
@RestController
@RequestMapping("nodules/bttiebatypemapper")
public class BtTiebaTypeMapperController {
    @Autowired
    private BtTiebaTypeMapperService btTiebaTypeMapperService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("nodules:bttiebatypemapper:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = btTiebaTypeMapperService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mapperId}")
    //@RequiresPermissions("nodules:bttiebatypemapper:info")
    public R info(@PathVariable("mapperId") Long mapperId){
		BtTiebaTypeMapperEntity btTiebaTypeMapper = btTiebaTypeMapperService.getById(mapperId);

        return R.ok().put("btTiebaTypeMapper", btTiebaTypeMapper);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:bttiebatypemapper:save")
    public R save(@RequestBody BtTiebaTypeMapperEntity btTiebaTypeMapper){
		btTiebaTypeMapperService.save(btTiebaTypeMapper);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:bttiebatypemapper:update")
    public R update(@RequestBody BtTiebaTypeMapperEntity btTiebaTypeMapper){
		btTiebaTypeMapperService.updateById(btTiebaTypeMapper);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:bttiebatypemapper:delete")
    public R delete(@RequestBody Long[] mapperIds){
		btTiebaTypeMapperService.removeByIds(Arrays.asList(mapperIds));

        return R.ok();
    }

}
