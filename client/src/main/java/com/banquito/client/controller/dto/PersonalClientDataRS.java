package com.banquito.client.controller.dto;

import java.io.Serializable;
import java.util.List;

import com.banquito.client.model.ClientAddress;
import com.banquito.client.model.ClientPhone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalClientDataRS implements Serializable{

    private String identificationType;
    private String identification;
    private String fullname;
    private String email;
    private String gender;
    private String nationality;

    private List<ClientPhone> phone;
    private List<ClientAddress> address;

}
