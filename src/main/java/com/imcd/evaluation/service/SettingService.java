package com.imcd.evaluation.service;

import com.imcd.evaluation.dto.SettingDto;
import com.imcd.evaluation.entity.Setting;
import com.imcd.evaluation.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SettingService {


    private final SettingRepository settingRepository;

    public List<SettingDto> getDateList() {
        return settingRepository.findAll()
                .stream()
                .map(SettingDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Transactional
    public void saveDate(SettingDto settingDto) {
        settingRepository.save(SettingDto.toEntity(settingDto));
    }

    @Transactional
    public void editDate(Long settingNo, SettingDto settingDto) {
        Optional<Setting> optionalSetting = settingRepository.findById(settingNo);
        if(optionalSetting.isPresent()) {
            Setting setting = optionalSetting.get();
            setting.setName(settingDto.getName());
            setting.setStartDate(LocalDate.parse(settingDto.getStartDate()));
            setting.setEndDate(LocalDate.parse(settingDto.getEndDate()));
        }
    }

    @Transactional
    public void deleteDate(Long settingNo) {
        settingRepository.deleteById(settingNo);
    }
}
