package org.ait.dogservices.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ErrorDto {
    private String field;
    private String message;
    private String rejectedValue;
}
