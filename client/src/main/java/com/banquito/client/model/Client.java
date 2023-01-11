package com.banquito.client.model;



import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "clients")
@CompoundIndexes({
    @CompoundIndex(name = "idxu_clients_typeIdentificationIdentification",
    def = "{'identificationType': 1, 'identification': 1}", unique = true)
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

    private List<ClientRelationship> relationship;
    private List<ClientReference> reference;
    private List<ClientPhone> phone;
    private List<ClientAddress> address;

    @Version
    private Long version;
}
