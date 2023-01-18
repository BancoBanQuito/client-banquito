package com.banquito.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.client.controller.dto.ClientRQ;
import com.banquito.client.controller.dto.ClientRS;
import com.banquito.client.controller.dto.NewClientRQ;
import com.banquito.client.controller.dto.PersonalClientDataRS;
import com.banquito.client.controller.mapper.ClientMapper;
import com.banquito.client.model.Client;
import com.banquito.client.service.ClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping(value = "/{idCliente}")
    public ResponseEntity<ClientRS> getClientById(@PathVariable("idCliente") String id){
        Client client = this.clientService.findClientById(id);
        if (client != null){
            return ResponseEntity.ok(ClientMapper.toClientRS(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/client/{idCliente}")
    public ResponseEntity<PersonalClientDataRS> getPersoanlDataClientById(@PathVariable("idCliente") String id){
        Client client = this.clientService.findClientById(id);
        if (client != null){
            return ResponseEntity.ok(ClientMapper.toPersonalDataClient(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/clients/{lastname}")
    public ResponseEntity<List<Client>> getClientByLastName(@PathVariable("lastname") String lastname){
        List<Client> client = this.clientService.findClientBySimilarLastname(lastname);
        if (client != null){
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> createClient(@RequestBody NewClientRQ clientRQ){
        try {
            this.clientService.createClient(ClientMapper.toNewClient(clientRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/user/{idCliente}")
    public ResponseEntity<String> updateClientLikeBankUser(@PathVariable("idCliente") String id, @RequestBody ClientRQ clientRQ){
        try {
            this.clientService.updateClientLikeBankUser(id, ClientMapper.toClient(clientRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{idCliente}")
    public ResponseEntity<String> updateClient(@PathVariable("idCliente") String id, @RequestBody ClientRQ clientRQ){
        try {
            this.clientService.updateClient(id, ClientMapper.toClient(clientRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
