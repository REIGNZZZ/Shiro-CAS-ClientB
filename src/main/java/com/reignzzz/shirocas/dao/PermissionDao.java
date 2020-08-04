package com.reignzzz.shirocas.dao;

import com.reignzzz.shirocas.entity.Permission;

import java.util.List;
import java.util.Set;

public interface PermissionDao {
    Set<String> getCodesByRoleIds(List<Long> roleIds);

    List<Permission> getPermissions();
}
