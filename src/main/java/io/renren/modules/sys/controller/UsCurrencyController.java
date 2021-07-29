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

import io.renren.modules.sys.entity.UsCurrencyEntity;
import io.renren.modules.sys.service.UsCurrencyService;
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
@RequestMapping("nodules/uscurrency")
public class UsCurrencyController {
    @Autowired
    private UsCurrencyService usCurrencyService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("nodules:uscurrency:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = usCurrencyService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{currencyId}")
    //@RequiresPermissions("nodules:uscurrency:info")
    public R info(@PathVariable("currencyId") Long currencyId){
		UsCurrencyEntity usCurrency = usCurrencyService.getById(currencyId);

        return R.ok().put("usCurrency", usCurrency);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:uscurrency:save")
    public R save(@RequestBody UsCurrencyEntity usCurrency){
		usCurrencyService.save(usCurrency);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:uscurrency:update")
    public R update(@RequestBody UsCurrencyEntity usCurrency){
		usCurrencyService.updateById(usCurrency);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:uscurrency:delete")
    public R delete(@RequestBody Long[] currencyIds){
		usCurrencyService.removeByIds(Arrays.asList(currencyIds));

        return R.ok();
    }

}
