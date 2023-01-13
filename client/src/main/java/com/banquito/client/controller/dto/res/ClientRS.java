package com.banquito.client.controller.dto.res;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRS implements Serializable {

    // PREGUNTAR POR ESTO
    private static final long serialVersionUID = 1L;

    private String lastname;
    private String firstname;
    private String fullname;
    private String status;
    private String email;
    private Date birthDate;
    private String gender;
    private String companyType;
    private String appLegalRepresent;
    private String articlesAssociatedDoc;
    private String basicServicesDocument;
    private String career;
    private String companyName;
    private Timestamp createDateCompany;
    private String fingerPrint;
    private String incomeTaxDocument;
    private Timestamp lastStatusDate;
    private String maritalStatus;
    private String monthlyAvgIncome;
    private String nationality;
    private String signature;
    private String taxPaymentPlace;
    private String tinDocument;
    private String workStatus;
    private String segment;
    private String nameSegment;
    private String statusSegment;
    private Date creationDate;

    // PREGUNTAR POR ESTO
    List<ClientRelationshipRS> clientRelationships;
    List<ClientAddressRS> clientAddresses;
    List<ClientPhoneRS> clientPhones;
    List<ClientReferenceRS> clientReferences;

}
