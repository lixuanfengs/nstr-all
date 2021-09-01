package com.nstr.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nstr.common.core.entity.system.UserRole;


public interface IUserRoleService extends IService<UserRole> {

    void deleteUserRolesByRoleId(String[] roleIds);

    void deleteUserRolesByUserId(String[] userIds);
}
