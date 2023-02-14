package com.banquito.client.mock;

import java.util.Date;

import com.banquito.client.controller.dto.UpdateClientRQ;
import com.banquito.client.model.Client;

public class ClientMock {
    
    public UpdateClientRQ createUpdateClientRQ(){
        return UpdateClientRQ.builder()
            .identificationType("DNI")
            .identification("1720744943")
            .lastname("cade")
            .email("test@gmail.com")
            .build();
    }

    public Client createClient(){
        return Client.builder()
            .identificationType("DNI")
            .identification("1720744943")
            .lastname("cade")
            .email("test@gmail.com")
            .build();
    }
}
