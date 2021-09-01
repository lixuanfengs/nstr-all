package com.nstr.instrument.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nstr.instrument.entity.SingleInstrumentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 单台套科学仪器设备
 *
 * @author lixuanfeng
 * @email lixf19970809@gmail.com
 * @date 2021-06-10 16:40:45
 */
@Mapper
public interface SingleInstrumentDao extends BaseMapper<SingleInstrumentEntity> {

}
