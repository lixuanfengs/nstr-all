package com.nstr.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nstr.common.core.entity.system.Menu;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户名查询权限信息
     * @param username 用户名称
     * @return 权限信息
     */
    List<Menu> findUserPermissions(String username);

    /**
     * 通过用户名查询菜单信息
     * @param username 用户名
     * @return 菜单信息
     */
    List<Menu> findUserMenus(String username);
}
