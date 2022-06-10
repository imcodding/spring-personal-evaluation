package com.imcd.evaluation.controller;

import com.imcd.evaluation.dto.SettingDto;
import com.imcd.evaluation.service.SettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/evaluate/setting")
public class SettingController {

    private final SettingService settingService;

    @GetMapping("/date")
    public String settingDateForm() {
        return "evaluate/setting/date";
    }

    @PostMapping("/date")
    public void createDate(@ModelAttribute SettingDto settingDto) {
        settingService.saveDate(settingDto);
    }

    @PostMapping("/date/{settingNo}/edit")
    public void editDate(@PathVariable Long settingNo, @ModelAttribute SettingDto settingDto) {
        settingService.editDate(settingNo, settingDto);
    }

    @DeleteMapping("/date/{settingNo}/delete")
    public void deleteDate(@PathVariable Long settingNo) {
        settingService.deleteDate(settingNo);
    }
}
