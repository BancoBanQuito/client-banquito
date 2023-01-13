package com.banquito.client.controller.mapper;

import com.banquito.client.controller.dto.ClientRQ;
import com.banquito.client.controller.dto.ClientRS;
import com.banquito.client.model.Client;

public class ClientMapper {
    
    public static Client toClient(ClientRQ clientRQ) {
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