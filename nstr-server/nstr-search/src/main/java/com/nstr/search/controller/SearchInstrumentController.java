package com.nstr.search.controller;


import com.alibaba.fastjson.TypeReference;
import com.nstr.common.core.utils.R;
import com.nstr.search.fegin.instrument.InstrumentFegin;
import com.nstr.search.service.ISearchInstrumentService;
import com.nstr.search.vo.SingleInstrumentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("search/save")
public class SearchInstrumentController {

    @Autowired
    ISearchInstrumentService iSearchInstrumentService;

    @Autowired
    InstrumentFegin instrumentFegin;

    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id) {
        SingleInstrumentVo singleInstrument = new SingleInstrumentVo();
        R info = instrumentFegin.info(id);
        if (info.getCode() == 0) {
            singleInstrument = info.getData("singleInstrument", new TypeReference<SingleInstrumentVo>() {
            });

        } else {
            R.error(500, "数据错误");
        }

        return R.ok().put("singleInstrument", singleInstrument);
    }


}
