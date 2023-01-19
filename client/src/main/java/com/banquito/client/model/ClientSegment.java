package com.banquito.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientSegment {

    private String code;
    private String name;
    private String status;
}
