package com.banquito.client.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "clients")
@CompoundIndexes({
        @CompoundIndex(name = "idxu_clients_identificationTypeAndIdentification", def = "{'identificationType': 1, 'identification': 1}", unique = true)
})
public class Client {

    @Id
    private String id;
    private String identificationType;
    private String identification;

    @Indexed
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

    private ClientRelationship relationship;
    private ClientReference reference;
    private ClientPhone phone;
    private ClientAddress address;
    private ClientSegment segment;

    @Version
    private Long version;
}
