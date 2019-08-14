package com.liuchang.heartbeat.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 11:03 2019/7/4
 * @ Description：
 * @ Modified By：
 */
@Controller
public class BaseController {
    @RequestMapping("/login")
    public String index(){
        return "base/index";
    }

    @RequestMapping("/header")
    public String header(){
        return "base/header";
    }
}
