package com.banquito.client.model;

import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ClientReference {
    
    private String nameReference;
    private String phoneReference;
    private String relatedReference;
}
