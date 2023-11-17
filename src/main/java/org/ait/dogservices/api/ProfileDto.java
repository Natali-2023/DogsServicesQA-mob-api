package org.ait.dogservices.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ProfileDto {
    private int id;
    private String email;
    private String userName;
    private String role;
}
