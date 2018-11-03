package cn.business;

import cn.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> listRoles(String pwd);
}
