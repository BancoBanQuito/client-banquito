package com.banquito.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientSegment {

    private String code;
    private String name;
    private String status;
}
