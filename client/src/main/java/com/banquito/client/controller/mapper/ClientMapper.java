package com.banquito.client.controller.mapper;

import com.banquito.client.controller.dto.ClientRQ;
import com.banquito.client.controller.dto.ClientRS;
import com.banquito.client.model.Client;

public class ClientMapper {
    
    public static Client toClient(Client client) {
        return Client.builder()
            .identificationType(client.getIdentificationType())
            .identification(client.getIdentification())
            .lastname(client.getLastname())
            .firstname(client.getFirstname())
            .email(client.getEmail())
            .birthDate(client.getBirthDate())
            .gender(client.getGender())
            .companyType(client.getCompanyType())
            .appLegalRepresent(client.getAppLegalRepresent())
            .articlesAssociatedDoc(client.getArticlesAssociatedDoc())
            .basicServicesDocument(client.getBasicServicesDocument())
            .career(client.getCareer())
            .companyName(client.getCompanyName())
            .createDateCompany(client.getCreateDateCompany())
            .fingerPrint(client.getFingerPrint())
            .incomeTaxDocument(client.getIncomeTaxDocument())
            .lastStatusDate(client.getLastStatusDate())
            .maritalStatus(client.getMaritalStatus())
            .monthlyAvgIncome(client.getMonthlyAvgIncome())
            .nationality(client.getNationality())
            .signature(client.getSignature())
            .taxPaymentPlace(client.getTaxPaymentPlace())
            .tinDocument(client.getTinDocument())
            .workStatus(client.getWorkStatus())
            .segment(client.getSegment())
            .nameSegment(client.getNameSegment())
            .statusSegment(client.getStatusSegment())
            //AQUI DEBERIA IR LO SIGUIENTE PERO DA ERROR
            // .address(clientRQ.getClientAddressRQ())
            // .phone(clientRQ.getClientPhoneRQ())
            // .reference(clientRQ.getClientReferenceRQ())
            // .relationship(clientRQ.getClientRelationshipRQ())
            .build();
    }

    public static ClientRS toClientRS(Client client){
        return ClientRS.builder()
            .id(client.getId())
            .identificationType(client.getIdentificationType())
            .identification(client.getIdentification())
            .lastname(client.getLastname())
            .firstname(client.getFirstname())
            .email(client.getEmail())
            .birthDate(client.getBirthDate())
            .gender(client.getGender())
            .companyType(client.getCompanyType())
            .appLegalRepresent(client.getAppLegalRepresent())
            .articlesAssociatedDoc(client.getArticlesAssociatedDoc())
            .basicServicesDocument(client.getBasicServicesDocument())
            .career(client.getCareer())
            .companyName(client.getCompanyName())
            .createDateCompany(client.getCreateDateCompany())
            .fingerPrint(client.getFingerPrint())
            .incomeTaxDocument(client.getIncomeTaxDocument())
            .lastStatusDate(client.getLastStatusDate())
            .maritalStatus(client.getMaritalStatus())
            .monthlyAvgIncome(client.getMonthlyAvgIncome())
            .nationality(client.getNationality())
            .signature(client.getSignature())
            .taxPaymentPlace(client.getTaxPaymentPlace())
            .tinDocument(client.getTinDocument())
            .workStatus(client.getWorkStatus())
            .segment(client.getSegment())
            .nameSegment(client.getNameSegment())
            .statusSegment(client.getStatusSegment())
            .build();
    }
}