package com.reignzzz.shirocas.dao;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    Set<String> getRolesByUid(Long id);

    List<Long> getRoleIdsByUid(Long id);
}
