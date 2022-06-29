package com.imcd.evaluation.service;

import com.imcd.evaluation.dto.SettingDto;
import com.imcd.evaluation.dto.UserDto;
import com.imcd.evaluation.entity.Setting;
import com.imcd.evaluation.repository.SettingRepository;
import com.imcd.evaluation.repository.TargetRepository;
import com.imcd.evaluation.repository.UserRepository;
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
    private final TargetRepository targetRepository;
    private final UserRepository userRepository;

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

    public List<UserDto> getUserList() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }
}
