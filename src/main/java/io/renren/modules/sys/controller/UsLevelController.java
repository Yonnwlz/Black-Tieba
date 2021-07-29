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

import io.renren.modules.sys.entity.UsLevelEntity;
import io.renren.modules.sys.service.UsLevelService;
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
@RequestMapping("nodules/uslevel")
public class UsLevelController {
    @Autowired
    private UsLevelService usLevelService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("nodules:uslevel:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usLevelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{levelId}")
    //@RequiresPermissions("nodules:uslevel:info")
    public R info(@PathVariable("levelId") Long levelId){
		UsLevelEntity usLevel = usLevelService.getById(levelId);

        return R.ok().put("usLevel", usLevel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:uslevel:save")
    public R save(@RequestBody UsLevelEntity usLevel){
		usLevelService.save(usLevel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:uslevel:update")
    public R update(@RequestBody UsLevelEntity usLevel){
		usLevelService.updateById(usLevel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:uslevel:delete")
    public R delete(@RequestBody Long[] levelIds){
		usLevelService.removeByIds(Arrays.asList(levelIds));

        return R.ok();
    }

}
