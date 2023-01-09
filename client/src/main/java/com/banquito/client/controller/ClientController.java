package com.banquito.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.client.service.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
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
    public Object singUp() {
        return ResponseEntity.status(200).body("Client web created");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login() {
        return ResponseEntity.status(200).body("Client web created");
    }

    /**************
     * REFERENCE
    ***************/

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

    /**************
     * ADDRESS
    ***************/

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

    /**************
     * PHONE
    ***************/
    
    @RequestMapping(value = "/phone", method = RequestMethod.PUT)
    public Object updatePhone() {
        return ResponseEntity.status(200).body("Address update");
    }

}
