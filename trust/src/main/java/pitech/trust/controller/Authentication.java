package pitech.trust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/auth")
public class Authentication {

    @GetMapping(value = "/login")
    @ResponseBody
    public String login() {
        return "Welcome to Trust";
    }

    @GetMapping(value = "/logout")
    @ResponseBody
    public String logout() {
        return "Goodbye user";
    }
}
