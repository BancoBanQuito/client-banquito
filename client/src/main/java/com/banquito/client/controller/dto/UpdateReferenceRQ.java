package com.banquito.client.controller.dto;

import com.banquito.client.model.ClientReference;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateReferenceRQ {
    private String identificationType;
    private String identification;
    private ClientReference reference;
}
