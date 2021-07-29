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

import io.renren.modules.sys.entity.UsUserEntity;
import io.renren.modules.sys.service.UsUserService;
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
@RequestMapping("nodules/ususer")
public class UsUserController {
    @Autowired
    private UsUserService usUserService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("nodules:ususer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usUserService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{userId}")
    //@RequiresPermissions("nodules:ususer:info")
    public R info(@PathVariable("userId") Long userId){
		UsUserEntity usUser = usUserService.getById(userId);

        return R.ok().put("usUser", usUser);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:ususer:save")
    public R save(@RequestBody UsUserEntity usUser){
		usUserService.save(usUser);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:ususer:update")
    public R update(@RequestBody UsUserEntity usUser){
		usUserService.updateById(usUser);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:ususer:delete")
    public R delete(@RequestBody Long[] userIds){
		usUserService.removeByIds(Arrays.asList(userIds));

        return R.ok();
    }

}
