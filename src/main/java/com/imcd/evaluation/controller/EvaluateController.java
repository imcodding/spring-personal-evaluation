package com.imcd.evaluation.controller;

import com.imcd.evaluation.TestInitData;
import com.imcd.evaluation.code.SelectCode;
import com.imcd.evaluation.service.TargetService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Select;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/evaluate")
public class EvaluateController {

    private final TargetService targetService;

    @GetMapping("/new")
    public String evaluateForm(Model model) {
        model.addAttribute("scoreCodeList", TestInitData.getScoreSelectList());
        model.addAttribute("scoreTypeList", TestInitData.getScoreTypeList());
        model.addAttribute("targetList", targetService.getTargetList());
        return "evaluate/addForm";
    }

    @GetMapping("/status")
    public String evaluateStatus() {
        return "evaluate/status";
    }

    @GetMapping("/result/{userId}")
    public String evaluateResult(@PathVariable String userId) {
        return "evaluate/result";
    }

    @GetMapping("/scoreType")
    @ResponseBody
    public List<SelectCode> getScoreType() {
        return TestInitData.getScoreTypeList();
    }
}
