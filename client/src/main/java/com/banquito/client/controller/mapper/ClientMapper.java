package com.banquito.client.controller.mapper;

import com.banquito.client.controller.dto.ClientRQ;
import com.banquito.client.controller.dto.ClientRS;
import com.banquito.client.controller.dto.IdentificationClienRQ;
import com.banquito.client.controller.dto.NewClientRQ;
import com.banquito.client.controller.dto.PersonalClientDataRS;
import com.banquito.client.controller.dto.UserRQ;
import com.banquito.client.model.Client;
import com.banquito.client.model.User;

public class ClientMapper {
    
    public static Client toNewClient(NewClientRQ client) {
        return Client.builder()
            .identificationType(client.getIdentificationType())
            .identification(client.getIdentification())
            .lastname(client.getLastname())
            .firstname(client.getFirstname())
            .email(client.getEmail())
            .birthDate(client.getBirthDate())
            .gender(client.getGender())
            .career(client.getCareer())
            .companyName(client.getCompanyName())
            .companyType(client.getCompanyType())
            .createDateCompany(client.getCreateDateCompany())
            .appLegalRepresent(client.getAppLegalRepresent())
            .articlesAssociatedDoc(client.getArticlesAssociatedDoc())
            .basicServicesDocument(client.getBasicServicesDocument())
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

            .phone(client.getPhone())
            .address(client.getAddress())
            .reference(client.getReference())
            .relationship(client.getRelationship())
            .build();
    }

    public static Client identificationstoClient(IdentificationClienRQ client){
        return Client.builder()
            .identification(client.getIdentification())
            .identificationType(client.getIdentificationType())
            .build();
    }

    public static Client userToClient(UserRQ user){
        return Client.builder()
            .identification(user.getIdentification())
            .identificationType(user.getIdentificationType())
            .email(user.getEmail())
            .user(user.getUser())
            .build();
    }

    public static ClientRS toClientRS(Client client){
        return ClientRS.builder()
        .identificationType(client.getIdentificationType())
        .identification(client.getIdentification())
        .lastname(client.getLastname())
        .firstname(client.getFirstname())
        .email(client.getEmail())
        .birthDate(client.getBirthDate())
        .gender(client.getGender())
        .career(client.getCareer())
        .companyName(client.getCompanyName())
        .companyType(client.getCompanyType())
        .createDateCompany(client.getCreateDateCompany())
        .appLegalRepresent(client.getAppLegalRepresent())
        .articlesAssociatedDoc(client.getArticlesAssociatedDoc())
        .basicServicesDocument(client.getBasicServicesDocument())
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

        .phone(client.getPhone())
        .address(client.getAddress())
        .reference(client.getReference())
        .relationship(client.getRelationship())
        .user(client.getUser())
        .build();
    }

    public static PersonalClientDataRS toPersonalDataClient(Client client){
        return PersonalClientDataRS.builder()
        .identificationType(client.getIdentificationType())
        .identification(client.getIdentification())
        .fullname(client.getFullname())
        .email(client.getEmail())
        .gender(client.getGender())
        .nationality(client.getNationality())
        .phone(client.getPhone())
        .address(client.getAddress())
        .build();
    }
}
