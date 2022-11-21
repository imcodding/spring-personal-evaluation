package com.imcd.evaluation.controller;

import com.imcd.evaluation.service.SettingService;
import com.imcd.evaluation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class ViewController {

    private final SettingService settingService;
    private final UserService userService;

    //평가기간설정
    @GetMapping("/evaluate/setting/date")
    public String settingDateForm(Model model) {
        model.addAttribute("dateList", settingService.getDateList());
        return "/evaluate/setting/date";
    }
    //평가대상설정
    @GetMapping("/evaluate/setting/target")
    public String settingTargetForm(Model model) {
        model.addAttribute("userList", userService.getUserList());
        return "/evaluate/setting/target";
    }
    //평가진행현황
    @GetMapping("/evaluate/status")
    public String evaluateStatus() {
        return "/evaluate/status";
    }
    //평가기준
    @GetMapping("/evaluate/standard")
    public String evaluateStandard() {
        return "/evaluate/standard";
    }
    //평가결과
    @GetMapping("/evaluate/result")
    public String evaluateResult() {
        return "/evaluate/result";
    }
    //평가
    @GetMapping("/evaluate/form")
    public String evaluateForm() {
        return "/evaluate/addForm";
    }
}
