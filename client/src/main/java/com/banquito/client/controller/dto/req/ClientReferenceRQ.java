package com.banquito.client.controller.dto.req;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientReferenceRQ implements Serializable {

    private String nameReference;
    private String phoneReference;
    private String relatedReference;
}
