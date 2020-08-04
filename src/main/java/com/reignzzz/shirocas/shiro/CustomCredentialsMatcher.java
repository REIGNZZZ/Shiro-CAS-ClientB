package com.reignzzz.shirocas.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo info) {
        /*try {
            UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
            String password = new String(token.getPassword());
            SimpleHash simpleHash = new SimpleHash("MD5", password, null, 1024);
            Object accountCredentials = this.getCredentials(info);
            return equals(simpleHash.toString(), accountCredentials.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new IncorrectCredentialsException("重放攻击行为");
        }*/
        return super.doCredentialsMatch(authenticationToken, info);
    }
}
