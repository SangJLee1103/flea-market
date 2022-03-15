package com.sangjun.flea.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorData {
    String code;
    String message;
}
