package com.banquito.client.controller.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.banquito.client.model.ClientAddress;
import com.banquito.client.model.ClientPhone;
import com.banquito.client.model.ClientReference;
import com.banquito.client.model.ClientRelationship;
import com.banquito.client.model.ClientSegment;
import com.banquito.client.model.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRS implements Serializable{

    private String id;
    private String identificationType;
    private String identification;
    private String lastname;
    private String firstname;
    private String fullname;
    private String status;
    private String email;
    private Date birthDate;
    private String gender;
    private String career;
    private String companyName;
    private String companyType;
    private Date createDateCompany;
    private String appLegalRepresent;
    private String articlesAssociatedDoc;
    private String basicServicesDocument;
    private String fingerPrint;
    private String incomeTaxDocument;
    private Date lastStatusDate;
    private String maritalStatus;
    private String monthlyAvgIncome;
    private String nationality;
    private String signature;
    private String taxPaymentPlace;
    private String tinDocument;
    private String workStatus;
    private Date creationDate;

    private User user;
    private List<ClientRelationship> relationship;
    private List<ClientReference> reference;
    private List<ClientPhone> phone;
    private List<ClientAddress> address;
    private List<ClientSegment> segment;

}
