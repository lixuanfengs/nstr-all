package com.nstr.auth.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nstr.common.core.entity.system.SystemUser;

public interface UserMapper extends BaseMapper<SystemUser> {

    SystemUser findByName(String username);
}
