package com.banquito.client.controller.mapper;

import com.banquito.client.controller.dto.ClientRQ;
import com.banquito.client.controller.dto.ClientRS;
import com.banquito.client.controller.dto.NewClientRQ;
import com.banquito.client.controller.dto.PersonalClientDataRSRQ;
import com.banquito.client.controller.dto.SignatureRQ;
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
                .segment(client.getSegment())
                .build();
    }

    public static Client toClient(ClientRQ client) {
        return Client.builder()
                .email(client.getEmail())
                .gender(client.getGender())
                .career(client.getCareer())
                .phone(client.getPhone())
                .address(client.getAddress())
                .build();
    }

    public static ClientRS toClientRS(Client client) {
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
                .segment(client.getSegment())
                .build();
    }

    public static PersonalClientDataRSRQ toPersonalDataClient(Client client) {
        return PersonalClientDataRSRQ.builder()
                .identificationType(client.getIdentificationType())
                .identification(client.getIdentification())
                .fullname(client.getFullname())
                .email(client.getEmail())
                .gender(client.getGender())
                .career(client.getCareer())
                .phone(client.getPhone())
                .address(client.getAddress())
                .build();
    }

    public static SignatureRQ toSignature(Client client){
        return SignatureRQ.builder()
        .typeIndentification(client.getIdentificationType())
        .identification(client.getIdentification())
        .name(client.getFirstname())
        .lastName(client.getLastname())
        .signature(client.getSignature())
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

    public static UserRQ toUser(Client client){
        return UserRQ.builder()
            .identification(client.getIdentification())
            .identificationType(client.getIdentificationType())
            .email(client.getEmail())
            .user(client.getUser())
            .build();
    }
}
