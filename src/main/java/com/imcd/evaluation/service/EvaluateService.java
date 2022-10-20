package com.imcd.evaluation.service;

import com.imcd.evaluation.repository.EvaluateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluateService {

    private final EvaluateRepository evaluateRepository;
}
