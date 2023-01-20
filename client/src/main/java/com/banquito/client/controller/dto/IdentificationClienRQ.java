package com.banquito.client.controller.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdentificationClienRQ implements Serializable{
    private String identification;
    private String identificationType;
}
