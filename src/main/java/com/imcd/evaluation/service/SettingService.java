package com.imcd.evaluation.service;

import com.imcd.evaluation.dto.SettingDto;
import com.imcd.evaluation.entity.Setting;
import com.imcd.evaluation.repository.SettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SettingService {


    private final SettingRepository settingRepository;
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

    public void deleteDate(Long settingNo) {
        settingRepository.deleteById(settingNo);
    }
}
