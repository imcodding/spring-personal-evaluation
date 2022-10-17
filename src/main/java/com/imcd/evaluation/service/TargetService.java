package com.imcd.evaluation.service;

import com.imcd.evaluation.dto.TargetDto;
import com.imcd.evaluation.entity.Target;
import com.imcd.evaluation.entity.User;
import com.imcd.evaluation.repository.TargetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TargetService {

    private final TargetRepository targetRepository;

//    public List<TargetDto> getTargetList() {
//        return targetRepository.findAll()
//                .stream()
//                .map(TargetDto::fromEntity)
//                .collect(Collectors.toList());
//    }

    public List<User> getTargetList() {
        return targetRepository.findTargetByUser();

    }

//    public List<TargetDto> getTargets() {
//        return targetRepository.findTargetList()
//                .stream()
//                .map(TargetDto::fromEntity)
//                .collect(Collectors.toList());
//    }
    public List<Target> getTargets() {
        List<Target> targetList = targetRepository.findAll();
        return targetRepository.findTargetList();
    }
}
