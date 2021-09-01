package com.nstr.auth.manager;

import com.nstr.auth.mapper.MenuMapper;
import com.nstr.auth.mapper.UserMapper;
import com.nstr.common.core.entity.system.Menu;
import com.nstr.common.core.entity.system.SystemUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);
        /*List<String> perms = new ArrayList<>();
        for (Menu m: userPermissions){
            perms.add(m.getPerms());
        }
        return StringUtils.join(perms, ",");*/
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }
}
