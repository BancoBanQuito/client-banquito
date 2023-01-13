package com.banquito.client.controller.dto.req;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientAddressRQ implements Serializable {

    private String codeLocation;
    private String addressLineOne;
    private String addressLineTwo;
    private String latitude;
    private String longitude;
}
