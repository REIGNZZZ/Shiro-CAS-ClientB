package com.reignzzz.shirocas.entity;

import java.io.Serializable;
import java.util.Set;

public class Role implements Serializable {

    private static final long serialVersionUID = -8334412605002967399L;
    private Long id;
    private String name;
    private String code;
    private Set<Permission> permissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
