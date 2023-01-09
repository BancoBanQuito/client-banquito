package com.banquito.client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.client.model.Client;
import com.banquito.client.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clientList = this.clientService.findAll();
        
        if (clientList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientList);
    }

    // ejemplo de lo q falta
    // @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    // public Object deposit() {
    //     return ResponseEntity.status(200).body("Deposit created");
    // }
}
