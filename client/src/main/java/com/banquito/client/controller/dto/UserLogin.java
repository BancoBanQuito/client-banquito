package com.banquito.client.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLogin implements Serializable{

    private String userName;
    private String password;
}