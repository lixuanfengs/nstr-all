package com.nstr.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nstr.common.core.entity.router.VueRouter;
import com.nstr.common.core.entity.system.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IMenuService extends IService<Menu> {

    /**
     * 通过用户名查询用户权限信息
     *
     * @param username 用户名
     * @return 权限信息
     */
    String findUserPermissions(String username);

    /**
     * 通过用户名创建对应的 Vue路由信息
     *
     * @param username 用户名
     * @return 路由信息
     */
    List<VueRouter<Menu>> getUserRouters(String username);

    /**
     * 获取用户菜单
     *
     * @param username 用户名
     * @return 用户菜单
     */
    List<Menu> findUserMenus(String username);

    /**
     * 获取用户菜单
     *
     * @param menu menu
     * @return 用户菜单
     */
    Map<String, Object> findMenus(Menu menu);

    /**
     * 获取菜单列表
     *
     * @param menu menu
     * @return 菜单列表
     */
    List<Menu> findMenuList(Menu menu);

    /**
     * 创建菜单
     *
     * @param menu menu
     */
    void createMenu(Menu menu);

    /**
     * 更新菜单
     *
     * @param menu menu
     */
    void updateMenu(Menu menu);

    /**
     * 递归删除菜单/按钮
     *
     * @param menuIds menuIds
     */
    void deleteMeuns(String[] menuIds);
}
