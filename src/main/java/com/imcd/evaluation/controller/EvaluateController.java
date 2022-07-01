package com.imcd.evaluation.controller;

import com.imcd.evaluation.TestInitData;
import com.imcd.evaluation.service.TargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/evaluate")
public class EvaluateController {

    private final TargetService targetService;

    @GetMapping("/new")
    public String evaluateForm(Model model) {
        model.addAttribute("scoreCodeList", TestInitData.getScoreSelectList());
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
}
