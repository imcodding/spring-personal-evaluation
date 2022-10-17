package com.imcd.evaluation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EvaluateDto {

    private Long userNo;
    private List<TargetDto> targetList = new ArrayList<>();

}
