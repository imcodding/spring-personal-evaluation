package com.imcd.evaluation.controller;

import com.imcd.evaluation.TestInitData;
import com.imcd.evaluation.code.SelectCode;
import com.imcd.evaluation.dto.TargetDto;
import com.imcd.evaluation.entity.Target;
import com.imcd.evaluation.service.TargetService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Select;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/evaluate")
public class EvaluateController {

    private final TargetService targetService;

    @GetMapping("/form")
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

    @GetMapping("/targets")
    @ResponseBody
    public List<Target> getTargets() { return targetService.getTargets(); }


    @PostMapping("/save")
    public void saveForm(@RequestBody TargetDto targetDto) {

    }
}
