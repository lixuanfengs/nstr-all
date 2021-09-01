package com.nstr.instrument.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.nstr.common.core.utils.PageUtils;
import com.nstr.instrument.entity.SingleInstrumentEntity;

import java.util.Map;

/**
 * 单台套科学仪器设备
 *
 * @author lixuanfeng
 * @email lixf19970809@gmail.com
 * @date 2021-06-10 16:40:45
 */
public interface SingleInstrumentService extends IService<SingleInstrumentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

