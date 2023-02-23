package com.banquito.client.mock;

import java.time.OffsetDateTime;
import java.util.Date;

import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.client.model.Client;
import com.banquito.client.model.ClientAddress;
import com.banquito.client.model.ClientPhone;
import com.banquito.client.model.ClientReference;
import com.banquito.client.model.ClientRelationship;
import com.banquito.client.model.ClientSegment;

public class NewClientMock {

    public ClientPhone mockPhone(){
        return ClientPhone.builder()
        .phoneNumber("+593960953023")
        .phoneType("date")
        .build();
    }

    public ClientAddress mockAddress(){
        return ClientAddress.builder()
        .codeLocation("123456789")
        .latitude("123456")
        .longitude("-5489362")
        .lineOne("Calle 1")
        .lineTwo("Calle 2")
        .build();
    }

    public ClientReference mockReference(){
        return ClientReference.builder()
        .name("Laila Hernandez")
        .phone("+593987245613")
        .related("Madre")
        .build();
    }

    public ClientRelationship mockRelationship(){
        String dateString = "1999-04-12T00:00:00.000+00:00";
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString);
        Date date = Date.from(offsetDateTime.toInstant());

        return ClientRelationship.builder()
        .name("Arnold Shortman")
        .startDate(date)
        .endDate(date)
        .build();
    }

    public ClientSegment mockSegment(){
        return ClientSegment.builder()
        .name("VIP")
        .code("123")
        .status("ACT")
        .build();
    }

    public Client mockClient(){
        
        String dateString = "1999-04-12T00:00:00.000+00:00";
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString);
        Date date = Date.from(offsetDateTime.toInstant());

        return Client.builder()
        .identificationType("DNI")
        .identification("1004805758")
        .lastname("Hernandez")
        .firstname("Isabela")
        .email("isabel.hernandez@gmail.com")
        .birthDate(date)
        .gender("F")
        .career("Programador")
        .companyName("COMPANY SAS")
        .companyType("Consultora")
        .createDateCompany(date)
        .appLegalRepresent("App representante legal")
        .articlesAssociatedDoc("Dcoumento de servicios asociados")
        .basicServicesDocument("Planilla de luz")
        .fingerPrint("Huella digital")
        .incomeTaxDocument("Documento de impuestos")
        .lastStatusDate(date)
        .maritalStatus("Soltera")
        .monthlyAvgIncome("Avg mensual")
        .nationality("Ecuatoriana")
        .signature("Firma cliente")
        .taxPaymentPlace("Ecuador")
        .tinDocument("Documento TIN")
        .workStatus("Dependencia")

        .phone(mockPhone())
        .address(mockAddress())
        .reference(mockReference())
        .relationship(mockRelationship())
        .segment(mockSegment())
        .build();
    }

    public Client mockIlegalClient(){
        
        String dateString = "2011-04-12T00:00:00.000+00:00";
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString);
        Date date = Date.from(offsetDateTime.toInstant());

        return Client.builder()
        .identificationType("DNI")
        .identification("1004805758")
        .lastname("Hernandez")
        .firstname("Isabela")
        .email("isabel.hernandez@gmail.com")
        .birthDate(date)
        .gender("F")
        .career("Programador")
        .companyName("COMPANY SAS")
        .companyType("Consultora")
        .createDateCompany(date)
        .appLegalRepresent("App representante legal")
        .articlesAssociatedDoc("Dcoumento de servicios asociados")
        .basicServicesDocument("Planilla de luz")
        .fingerPrint("Huella digital")
        .incomeTaxDocument("Documento de impuestos")
        .lastStatusDate(date)
        .maritalStatus("Soltera")
        .monthlyAvgIncome("Avg mensual")
        .nationality("Ecuatoriana")
        .signature("Firma cliente")
        .taxPaymentPlace("Ecuador")
        .tinDocument("Documento TIN")
        .workStatus("Dependencia")

        .phone(mockPhone())
        .address(mockAddress())
        .reference(mockReference())
        .relationship(mockRelationship())
        .segment(mockSegment())
        .build();
    }
}
