package com.nstr.instrument.controller;

import com.nstr.common.core.utils.PageUtils;
import com.nstr.common.core.utils.R;
import com.nstr.instrument.entity.SingleInstrumentEntity;
import com.nstr.instrument.service.SingleInstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 单台套科学仪器设备
 *
 * @author lixuanfeng
 * @email lixf19970809@gmail.com
 * @date 2021-06-10 16:40:45
 */
@RestController
@RequestMapping("instrument/singleinstrument")
public class SingleInstrumentController {
    @Autowired
    private SingleInstrumentService singleInstrumentService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = singleInstrumentService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id) {
        SingleInstrumentEntity singleInstrument = singleInstrumentService.getById(id);

        return R.ok().put("singleInstrument", singleInstrument);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SingleInstrumentEntity singleInstrument) {
        singleInstrumentService.save(singleInstrument);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SingleInstrumentEntity singleInstrument) {
        singleInstrumentService.updateById(singleInstrument);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids) {
        singleInstrumentService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
