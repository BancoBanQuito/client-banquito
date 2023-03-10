package com.banquito.client.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class ClientRelationship {

    private String name;
    private Date startDate;
    private Date endDate;
}
