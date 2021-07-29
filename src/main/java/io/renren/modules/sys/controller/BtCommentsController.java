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

import io.renren.modules.sys.entity.BtCommentsEntity;
import io.renren.modules.sys.service.BtCommentsService;
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
@RequestMapping("nodules/btcomments")
public class BtCommentsController {
    @Autowired
    private BtCommentsService btCommentsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("nodules:btcomments:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = btCommentsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{commentsId}")
    //@RequiresPermissions("nodules:btcomments:info")
    public R info(@PathVariable("commentsId") Long commentsId){
		BtCommentsEntity btComments = btCommentsService.getById(commentsId);

        return R.ok().put("btComments", btComments);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("nodules:btcomments:save")
    public R save(@RequestBody BtCommentsEntity btComments){
		btCommentsService.save(btComments);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("nodules:btcomments:update")
    public R update(@RequestBody BtCommentsEntity btComments){
		btCommentsService.updateById(btComments);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("nodules:btcomments:delete")
    public R delete(@RequestBody Long[] commentsIds){
		btCommentsService.removeByIds(Arrays.asList(commentsIds));

        return R.ok();
    }

}
