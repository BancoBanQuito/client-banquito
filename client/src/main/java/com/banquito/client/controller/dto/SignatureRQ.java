package com.banquito.client.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class SignatureRQ implements Serializable{
    
    String typeIndentification;
    String identification;
    String name;
    String lastName;
    String signature;

}
