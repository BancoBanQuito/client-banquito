package com.banquito.client.model;

import java.sql.Date;

import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ClientRelationship {

    private String name;
    private Date startDate;
    private Date endDate;
}