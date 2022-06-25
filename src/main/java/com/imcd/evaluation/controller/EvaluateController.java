package com.imcd.evaluation.controller;

import com.imcd.evaluation.TestInitData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/evaluate")
public class EvaluateController {

    @GetMapping("/new")
    public String evaluateForm(Model model) {
        model.addAttribute("scoreCodeList", TestInitData.getScoreSelectList());
        model.addAttribute("targetList", TestInitData.getTargetList());
        return "evaluate/addForm";
    }
}
