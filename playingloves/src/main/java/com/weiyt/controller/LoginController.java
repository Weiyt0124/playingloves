package com.weiyt.controller;

import com.weiyt.WebSecurityConfig;
import com.weiyt.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author weiyt
 */
@Controller
public class LoginController {

    private String flag= "flag";

    @Autowired
    private UserServiceImpl userServiceImpl;
    @RequestMapping("/{anNing}")
    public String login(@PathVariable String anNing) {

        return anNing;
    }


    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
        model.addAttribute("name", account);
        return "home";
    }


    @PostMapping("/loginPost")
    public
    @ResponseBody
    Map<String, Object> loginPost(@RequestParam Map<String, Object> param, HttpSession session) {
        Map<String, Object> result = userServiceImpl.login(param);
        if (!(Boolean) result.get(flag)) {
            return result;
        }
        // 设置session
        session.setAttribute(WebSecurityConfig.SESSION_KEY, result.get("nickname"));
        session.setAttribute("name", result.get("name"));
        session.setAttribute("id", result.get("id"));
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }


}

