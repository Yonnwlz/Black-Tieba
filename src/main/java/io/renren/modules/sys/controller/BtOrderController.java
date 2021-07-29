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

import io.renren.modules.sys.entity.BtOrderEntity;
import io.renren.modules.sys.service.BtOrderService;
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
@RequestMapping("nodules/btorder")
public class BtOrderController {
    @Autowired
    private BtOrderService btOrderService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("nodules:btorder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = btOrderService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{orderOnly}")
    //@RequiresPermissions("nodules:btorder:info")
    public R info(@PathVariable("orderOnly") String orderOnly){
		BtOrderEntity btOrder = btOrderService.getById(orderOnly);

        return R.ok().put("btOrder", btOrder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:btorder:save")
    public R save(@RequestBody BtOrderEntity btOrder){
		btOrderService.save(btOrder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:btorder:update")
    public R update(@RequestBody BtOrderEntity btOrder){
		btOrderService.updateById(btOrder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:btorder:delete")
    public R delete(@RequestBody String[] orderOnlys){
		btOrderService.removeByIds(Arrays.asList(orderOnlys));

        return R.ok();
    }

}
