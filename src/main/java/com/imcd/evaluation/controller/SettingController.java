package com.imcd.evaluation.controller;

import com.imcd.evaluation.TestInitData;
import com.imcd.evaluation.dto.SettingDto;
import com.imcd.evaluation.dto.TargetDto;
import com.imcd.evaluation.dto.UserDto;
import com.imcd.evaluation.entity.Target;
import com.imcd.evaluation.entity.User;
import com.imcd.evaluation.service.SettingService;
import com.imcd.evaluation.service.TargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/evaluate/setting")
public class SettingController {

    private final SettingService settingService;
    private final TargetService targetService;

    /*===============================================
        평가기간설정
    ===============================================*/
    @PostMapping("/date")
    public String addDate(@ModelAttribute("setting") SettingDto settingDto) {
        settingService.saveDate(settingDto);
        return "redirect:/evaluate/setting/date";
    }

    @PostMapping("/date/{settingNo}/edit")
    public void editDate(@PathVariable Long settingNo, @ModelAttribute SettingDto settingDto) {
        settingService.editDate(settingNo, settingDto);
    }

    @PostMapping("/date/{settingNo}/delete")
    public String deleteDate(@PathVariable Long settingNo) {
        settingService.deleteDate(settingNo);
        return "redirect:/evaluate/setting/date";
    }

    /*===============================================
        평가대상설정
    ===============================================*/
    @PostMapping("/target")
    public void addTarget(@RequestBody UserDto userDto) {
        settingService.saveTarget(userDto);
    }
//    @GetMapping("/target/list")
//    @ResponseBody
//    public List<UserDto> getTargetList(Long userNo) {
//        return targetService.getTargetList(userNo);
//    }

    public void checkValidation(SettingDto settingDto, BindingResult bindingResult) {
        if(!StringUtils.hasText(settingDto.getName())) {
            validation(bindingResult, "name", settingDto.getName(), "required");
        }
        if(!StringUtils.hasText(settingDto.getStartDate())) {
            validation(bindingResult, "startDate", settingDto.getName(), "required");
        }
        if(!StringUtils.hasText(settingDto.getEndDate())) {
            validation(bindingResult, "endDate", settingDto.getName(), "required");
        }
    }

    public void validation(BindingResult bindingResult, String field, Object objectValue, String message) {
        bindingResult.addError(new FieldError("setting", field, objectValue,
                false, new String[]{message}, null, ""));
    }
}
