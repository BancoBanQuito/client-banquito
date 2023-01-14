package com.banquito.client.controller.dto;

import java.io.Serializable;

import com.banquito.client.model.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRQ implements Serializable{
    
    private String typeIdentification;
    private String identification;
    private String email;
    private User user;

}
