package com.banquito.client.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientReferenceRS implements Serializable{
    
    private String nameReference;
    private String phoneReference;
    private String relatedReference;
}
