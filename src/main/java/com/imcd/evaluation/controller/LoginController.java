package com.imcd.evaluation.controller;

import com.imcd.evaluation.dto.UserDto;
import com.imcd.evaluation.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userDto, HttpServletResponse response) {
        loginService.login(userDto, response);
        return "home";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserDto userDto) {
        //TODO 아이디 중복 예외처리 필요
        loginService.join(userDto);
        return "login";
    }
}
