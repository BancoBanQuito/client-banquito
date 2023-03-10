package com.banquito.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientAddress {

    private String codeLocation;
    private String lineOne;
    private String lineTwo;
    private String latitude;
    private String longitude;
}
