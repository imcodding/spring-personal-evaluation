package com.imcd.evaluation.dto;

import com.imcd.evaluation.entity.Setting;
import com.imcd.evaluation.util.CommonUtils;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettingDto {

    private Long no;
    private String name;
    private String startDate;
    private String endDate;

    public static Setting toEntity(SettingDto settingDto) {
        return Setting.builder()
                .name(settingDto.getName())
                .startDate(CommonUtils.convertStringToLocalDateTime(settingDto.getStartDate()))
                .endDate(CommonUtils.convertStringToLocalDateTime(settingDto.getEndDate()))
                .build();
    }

    public static SettingDto fromEntity(Setting setting) {
        return SettingDto.builder()
                .no(setting.getNo())
                .name(setting.getName())
                .startDate(String.valueOf(setting.getStartDate()))
                .endDate(String.valueOf(setting.getEndDate()))
                .build();
    }
}
