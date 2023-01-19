package com.banquito.client.model;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class ClientReference {
    
    private String name;
    private String phone;
    private String related;
}
