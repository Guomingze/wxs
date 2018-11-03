package cn.dao;

import cn.pojo.Role;

import java.util.List;

public interface RoleDao {
    List<Role> listRoleBypwd(String pwd);
}
