package com.nstr.instrument.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nstr.common.core.utils.PageUtils;
import com.nstr.common.core.utils.Query;
import com.nstr.instrument.dao.SingleInstrumentDao;
import com.nstr.instrument.entity.SingleInstrumentEntity;
import com.nstr.instrument.service.SingleInstrumentService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("singleInstrumentService")
public class SingleInstrumentServiceImpl extends ServiceImpl<SingleInstrumentDao, SingleInstrumentEntity> implements SingleInstrumentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SingleInstrumentEntity> page = this.page(
                new Query<SingleInstrumentEntity>().getPage(params),
                new QueryWrapper<SingleInstrumentEntity>()
        );

        return new PageUtils(page);
    }

}