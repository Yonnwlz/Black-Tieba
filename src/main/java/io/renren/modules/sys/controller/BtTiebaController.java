package io.renren.modules.sys.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.BtTiebaEntity;
import io.renren.modules.sys.service.BtTiebaService;
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
@RequestMapping("nodules/bttieba")
public class BtTiebaController {
    @Autowired
    private BtTiebaService btTiebaService;

    /**
     * description 下架贴吧资源
     * param [parmas]
     * return io.renren.common.utils.R
     * author Yonnw丶
     * createTime 2021/7/26 14:41
     */
    @GetMapping("/allDelTiebaList/{tiebaStatus}")
    public R getAllDelTieba(@RequestParam Map<String,Object> parmas,@PathVariable Integer tiebaStatus){
        PageUtils page = btTiebaService.getTiebaStatus(parmas, tiebaStatus);
        return R.ok().put("page",page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list/{tiebaTypeId}")
    //@RequiresPermissions("nodules:bttieba:list")
    public R list(@RequestParam Map<String, Object> params,@PathVariable Integer tiebaTypeId){
        PageUtils page = btTiebaService.queryPage(params,tiebaTypeId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tiebaId}")
    //@RequiresPermissions("nodules:bttieba:info")
    public R info(@PathVariable("tiebaId") Long tiebaId){
		BtTiebaEntity btTieba = btTiebaService.getTieBaById(tiebaId);

        return R.ok().put("btTieba", btTieba);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:bttieba:save")
    public R save(@RequestBody BtTiebaEntity btTieba){
        btTiebaService.saveTieba(btTieba);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:bttieba:update")
    public R update(@RequestBody BtTiebaEntity btTieba){
		btTiebaService.updateTiebaById(btTieba);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:bttieba:delete")
    public R delete(@RequestBody Long[] tiebaIds){
		btTiebaService.removeByIds(Arrays.asList(tiebaIds));

        return R.ok();
    }

}
