package com.banquito.client.controller.mapper;

import com.banquito.client.controller.dto.ClientRQ;
import com.banquito.client.controller.dto.ClientRelationshipRQ;
import com.banquito.client.model.Client;

public class ClientMapper {
    
    public static Client toClient(ClientRQ clientRQ)
    {
        return Client.builder()
            .identificationType(clientRQ.getIdentificationType())
            .identification(clientRQ.getIdentification())
            .lastname(clientRQ.getLastname())
            .firstname(clientRQ.getFirstname())
            .email(clientRQ.getEmail())
            .birthDate(clientRQ.getBirthDate())
            .gender(clientRQ.getGender())
            .companyType(clientRQ.getCompanyType())
            .appLegalRepresent(clientRQ.getAppLegalRepresent())
            .articlesAssociatedDoc(clientRQ.getArticlesAssociatedDoc())
            .basicServicesDocument(clientRQ.getBasicServicesDocument())
            .career(clientRQ.getCareer())
            .companyName(clientRQ.getCompanyName())
            .createDateCompany(clientRQ.getCreateDateCompany())
            .fingerPrint(clientRQ.getFingerPrint())
            .incomeTaxDocument(clientRQ.getIncomeTaxDocument())
            .lastStatusDate(clientRQ.getLastStatusDate())
            .maritalStatus(clientRQ.getMaritalStatus())
            .monthlyAvgIncome(clientRQ.getMonthlyAvgIncome())
            .nationality(clientRQ.getNationality())
            .signature(clientRQ.getSignature())
            .taxPaymentPlace(clientRQ.getTaxPaymentPlace())
            .tinDocument(clientRQ.getTinDocument())
            .workStatus(clientRQ.getWorkStatus())
            .segment(clientRQ.getSegment())
            .nameSegment(clientRQ.getNameSegment())
            .statusSegment(clientRQ.getStatusSegment())
            .reference(clientRQ.getClientRelationshipRQ()            
            .reference(clientRQ.getReference())
            .phone(clientRQ.getPhone())
            .address(clientRQ.getAddress())
            .build();
    }
}
