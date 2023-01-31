package com.example.urlshortener.infrastructure;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ErrorModel {

    private String message;
}
