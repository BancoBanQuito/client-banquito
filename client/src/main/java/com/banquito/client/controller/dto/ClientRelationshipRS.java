package com.banquito.client.controller.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRelationshipRS implements Serializable{
    
    private String name;
    private Date startDate;
    private Date endDate;

}
