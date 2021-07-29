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

import io.renren.modules.sys.entity.BtTiebaImageEntity;
import io.renren.modules.sys.service.BtTiebaImageService;
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
@RequestMapping("nodules/bttiebaimage")
public class BtTiebaImageController {
    @Autowired
    private BtTiebaImageService btTiebaImageService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("nodules:bttiebaimage:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = btTiebaImageService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{imageId}")
    //@RequiresPermissions("nodules:bttiebaimage:info")
    public R info(@PathVariable("imageId") Long imageId){
		BtTiebaImageEntity btTiebaImage = btTiebaImageService.getById(imageId);

        return R.ok().put("btTiebaImage", btTiebaImage);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:bttiebaimage:save")
    public R save(@RequestBody BtTiebaImageEntity btTiebaImage){
		btTiebaImageService.save(btTiebaImage);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:bttiebaimage:update")
    public R update(@RequestBody BtTiebaImageEntity btTiebaImage){
		btTiebaImageService.updateById(btTiebaImage);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:bttiebaimage:delete")
    public R delete(@RequestBody Long[] imageIds){
		btTiebaImageService.removeByIds(Arrays.asList(imageIds));

        return R.ok();
    }

}
