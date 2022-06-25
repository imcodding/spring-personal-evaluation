package com.imcd.evaluation.code;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SelectCode {

    private String code;
    private int value;
    private String displayName;

    public SelectCode(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public SelectCode(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }
}
