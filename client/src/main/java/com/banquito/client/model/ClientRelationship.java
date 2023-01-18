package com.banquito.client.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ClientRelationship {

    private String name;
    private Date startDate;
    private Date endDate;
}
