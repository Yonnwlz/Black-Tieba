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

import io.renren.modules.sys.entity.NavigationEntity;
import io.renren.modules.sys.service.NavigationService;
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
@RequestMapping("nodules/navigation")
public class NavigationController {
    @Autowired
    private NavigationService navigationService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("nodules:navigation:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = navigationService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{naviId}")
    //@RequiresPermissions("nodules:navigation:info")
    public R info(@PathVariable("naviId") Long naviId){
		NavigationEntity navigation = navigationService.getById(naviId);

        return R.ok().put("navigation", navigation);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:navigation:save")
    public R save(@RequestBody NavigationEntity navigation){
		navigationService.save(navigation);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:navigation:update")
    public R update(@RequestBody NavigationEntity navigation){
		navigationService.updateById(navigation);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:navigation:delete")
    public R delete(@RequestBody Long[] naviIds){
		navigationService.removeByIds(Arrays.asList(naviIds));

        return R.ok();
    }

}
