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

import io.renren.modules.sys.entity.BtTiebaTypeEntity;
import io.renren.modules.sys.service.BtTiebaTypeService;
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
@RequestMapping("nodules/bttiebatype")
public class BtTiebaTypeController {
    @Autowired
    private BtTiebaTypeService btTiebaTypeService;

    /**
     * 列表
     */
    @RequestMapping("/list/{tiebaTypeId}")
    //@RequiresPermissions("nodules:bttiebatype:list")
    public R list(@RequestParam Map<String, Object> params,@PathVariable Integer tiebaTypeId){
        PageUtils page = btTiebaTypeService.queryPage(params,tiebaTypeId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{typeId}")
    //@RequiresPermissions("nodules:bttiebatype:info")
    public R info(@PathVariable("typeId") Long typeId){
		BtTiebaTypeEntity btTiebaType = btTiebaTypeService.getById(typeId);

        return R.ok().put("btTiebaType", btTiebaType);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:bttiebatype:save")
    public R save(@RequestBody BtTiebaTypeEntity btTiebaType){
		btTiebaTypeService.save(btTiebaType);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:bttiebatype:update")
    public R update(@RequestBody BtTiebaTypeEntity btTiebaType){
		btTiebaTypeService.updateById(btTiebaType);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:bttiebatype:delete")
    public R delete(@RequestBody Long[] typeIds){
		btTiebaTypeService.removeByIds(Arrays.asList(typeIds));

        return R.ok();
    }

}
