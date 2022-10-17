package com.imcd.evaluation.controller;

import com.imcd.evaluation.TestInitData;
import com.imcd.evaluation.code.Role;
import com.imcd.evaluation.dto.UserDto;
import com.imcd.evaluation.entity.User;
import com.imcd.evaluation.jwt.provider.JwtAuthProvider;
import com.imcd.evaluation.repository.UserRepository;
import com.imcd.evaluation.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final LoginService loginService;
    private final UserRepository userRepository;

    @GetMapping({"/", "/login"})
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userDto, HttpServletResponse response, Model model) {
        UserDto user = loginService.login(userDto, response);
        model.addAttribute("role", user.getRole());
        if(user.getRole().equals(Role.ADMIN)) {
            return "redirect:/evaluate/setting/date";
        } else {
            return "redirect:/evaluate/form";
        }
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("deptList", TestInitData.getDeptList());
        model.addAttribute("positionList", TestInitData.getPositionList());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Validated @ModelAttribute("user") UserDto userDto, BindingResult bindingResult, Model model) {

        checkValidation(userDto, bindingResult);

        if(bindingResult.hasErrors()) {
            model.addAttribute("deptList", TestInitData.getDeptList());
            model.addAttribute("positionList", TestInitData.getPositionList());
            return "signup";
        }

        loginService.join(userDto);

        return "redirect:/login";
    }

    public void checkValidation(UserDto userDto, BindingResult bindingResult) {

        if(!StringUtils.hasText(userDto.getUserId())) {
            validation(bindingResult, "userId", userDto.getUserId(), "required.user.userId");
        }
        Optional<User> user = userRepository.findUserByUserId(userDto.getUserId());
        if(user.isPresent()) {
            validation(bindingResult, "userId", userDto.getUserId(), "duplicate.user.userId");
        }
        if(!StringUtils.hasText(userDto.getPassword())) {
            validation(bindingResult, "password", userDto.getUserId(), "required.user.password");
        }
        if(userDto.getPassword().length() < 8) {
            validation(bindingResult, "password", userDto.getPassword(), "range.user.password");
        }
        if(!StringUtils.hasText(userDto.getName())) {
            validation(bindingResult, "name", userDto.getName(), "required.user.name");
        }
        if(!StringUtils.hasText(userDto.getDept())) {
            validation(bindingResult, "dept", userDto.getDept(), "required.user.dept");
        }
        if(!StringUtils.hasText(userDto.getPosition())) {
            validation(bindingResult, "position", userDto.getPosition(), "required.user.position");
        }
    }

    public void validation(BindingResult bindingResult, String field, Object objectValue, String message) {
        bindingResult.addError(new FieldError("user", field, objectValue,
                false, new String[]{message}, null, ""));
    }
}
