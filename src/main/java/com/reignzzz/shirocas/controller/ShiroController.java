package com.reignzzz.shirocas.controller;

import com.reignzzz.shirocas.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/shiros")
public class ShiroController {

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(User user, Integer rememberMe, HttpServletResponse response, HttpSession session) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/error.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error.jsp";
        }
        return "redirect:/view/index.jsp";
    }
}
