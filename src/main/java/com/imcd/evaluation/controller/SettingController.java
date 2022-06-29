package com.imcd.evaluation.controller;

import com.imcd.evaluation.TestInitData;
import com.imcd.evaluation.dto.SettingDto;
import com.imcd.evaluation.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/evaluate/setting")
public class SettingController {

    private final SettingService settingService;

    @GetMapping("/date")
    public String settingDateForm(Model model) {
        model.addAttribute("dateList", settingService.getDateList());
        return "evaluate/setting/date";
    }

    @PostMapping("/date")
    public String createDate(@ModelAttribute("setting") SettingDto settingDto, BindingResult bindingResult, Model model) {
//        checkValidation(settingDto, bindingResult);
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("dateList", settingService.getDateList());
//            return "date";
//        }
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

    @GetMapping("/target")
    public String settingTargetForm(Model model) {
        model.addAttribute("userList", settingService.getUserList());
        model.addAttribute("targetList", TestInitData.getTargetList());
        return "evaluate/setting/target";
    }

    @PostMapping("/target")
    public void createTarget(@RequestParam String userId) {

    }

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
