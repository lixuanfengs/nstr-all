package com.nstr.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nstr.common.core.entity.system.SystemUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<SystemUser> {

    /**
     * 查找用户详细信息
     * @param page 分页对象
     * @param user 用户对象，用于传递查询条件
     * @return
     */
    IPage<SystemUser> findUserDetailPage(Page page, @Param("user") SystemUser user);


    /**
     * 查找用户详细信息
     *
     * @param user 用户对象，用于传递查询条件
     * @return List<User>
     */
    List<SystemUser> findUserDetail(@Param("user") SystemUser user);
}
