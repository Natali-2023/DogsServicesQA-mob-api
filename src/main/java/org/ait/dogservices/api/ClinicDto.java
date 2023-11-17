package org.ait.dogservices.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class ClinicDto {
    private int id;
    private String name;

    private String description;

    private String webSite;

    private String country;

    private String clinicCity;

    private String postCode;

    private String address;

    private String telephoneNumber;
}
