package com.nstr.search.fegin.instrument;

import com.nstr.common.core.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value = "nstr-instrument")
public interface InstrumentFegin {

    @RequestMapping(value = "instrument/singleinstrument/info/{id}")
    public R info(@PathVariable("id") Integer id);
}
