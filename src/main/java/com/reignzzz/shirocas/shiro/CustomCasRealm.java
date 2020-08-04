package com.reignzzz.shirocas.shiro;

import com.reignzzz.shirocas.dao.PermissionDao;
import com.reignzzz.shirocas.dao.RoleDao;
import com.reignzzz.shirocas.dao.UserDao;
import com.reignzzz.shirocas.entity.User;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomCasRealm extends CasRealm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = principalCollection.oneByType(User.class);
//        这里需要一个String类型的集合
        Set<String> roles = roleDao.getRolesByUid(user.getId());
        List<Long> roleIds = roleDao.getRoleIdsByUid(user.getId());
        Set<String> permissions = permissionDao.getCodesByRoleIds(roleIds);
        Set<String> handlePermissions = new HashSet<String>();
        for (String code:permissions
        ) {
            if (code.contains("[")) {
                int b = code.indexOf("[") + 1;
                int e = code.indexOf("]");
                code = code.substring(b, e);
                handlePermissions.add(code);
            } else {
                handlePermissions.add(code);
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(handlePermissions);

        return info;
    }

    /*@Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userDao.getUserByName(username);
        if(user == null){
            throw new UnknownAccountException("没有该用户");
        }
        if (user.getStatus() == 0) {
            throw new LockedAccountException("该用户已被锁定");
        }
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        return info;
    }*/

}
