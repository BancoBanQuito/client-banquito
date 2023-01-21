package com.banquito.client.controller.dto;

import java.io.Serializable;
import java.util.List;

import com.banquito.client.model.ClientAddress;
import com.banquito.client.model.ClientPhone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRQ implements Serializable {

    private String identificationType;
    private String identification;
    private String email;
    private String gender;
    private String career;

    private ClientAddress address;
    private ClientPhone phone;
}
