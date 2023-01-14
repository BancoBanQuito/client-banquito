package com.banquito.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.client.controller.dto.ClientRS;
import com.banquito.client.controller.dto.UserRQ;
import com.banquito.client.controller.mapper.ClientMapper;
import com.banquito.client.model.Client;
import com.banquito.client.model.User;
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

    //obtener cliente por id
    @GetMapping(value = "/{idCliente}")
    public ResponseEntity<ClientRS> obtenerClientePorId(@PathVariable("idCliente") String id){
        Client client = this.clientService.findById(id);
        if (client != null){
            return ResponseEntity.ok(ClientMapper.toClientRS(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object create() {
        return ResponseEntity.status(200).body("Client created");
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object get() {
        return ResponseEntity.status(200).body("Client");
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Object update() {
        return ResponseEntity.status(200).body("Client created");
    }

    @RequestMapping(value = "/singup", method = RequestMethod.POST)
    public ResponseEntity<String> singUp(@RequestBody UserRQ newUser) {
        try {
            String typeIdentification = newUser.getTypeIdentification();
            String identification = newUser.getIdentification();
            String email = newUser.getEmail();
            User user = newUser.getUser();  
            boolean success = clientService.singUp(typeIdentification, identification, email, user);
            if (success) {
                return ResponseEntity.ok("User added successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login() {
        return ResponseEntity.status(200).body("Client web created");
    }

    @RequestMapping(value = "/reference", method = RequestMethod.POST)
    public Object createReference() {
        return ResponseEntity.status(200).body("Reference created");
    }

    @RequestMapping(value = "/reference", method = RequestMethod.GET)
    public Object getReference() {
        return ResponseEntity.status(200).body("Reference");
    }

    @RequestMapping(value = "/reference", method = RequestMethod.PUT)
    public Object updateReference() {
        return ResponseEntity.status(200).body("Reference update or Reference Logically DELETED");
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public Object createAddress() {
        return ResponseEntity.status(200).body("Address created");
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public Object getAddress() {
        return ResponseEntity.status(200).body("Address");
    }

    @RequestMapping(value = "/address", method = RequestMethod.PUT)
    public Object updateAddress() {
        return ResponseEntity.status(200).body("Address update");
    }

    @RequestMapping(value = "/phone", method = RequestMethod.PUT)
    public Object updatePhone() {
        return ResponseEntity.status(200).body("Address update");
    }

}
