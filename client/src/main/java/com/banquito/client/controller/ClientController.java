package com.banquito.client.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.client.controller.dto.req.ClientAddressRQ;
import com.banquito.client.controller.dto.res.ClientAddressRS;
import com.banquito.client.service.ClientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
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

    @RequestMapping(value = "/{id}/address", method = RequestMethod.POST)
    public ResponseEntity<ClientAddressRS> addAddress(@PathVariable("id") String id,
            @RequestBody ClientAddressRQ address) {
        ClientAddressRS response = clientService.addAddress(id, address);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/address", method = RequestMethod.GET)
    public ResponseEntity<List<ClientAddressRS>> getAddresses(@PathVariable("id") String id) {
        List<ClientAddressRS> addresses = clientService.getAddresses(id);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/address/{codeLocation}", method = RequestMethod.PUT)
    public ResponseEntity<ClientAddressRS> updateAddress(@PathVariable("id") String id,
            @PathVariable("codeLocation") String codeLocation, @RequestBody ClientAddressRQ address) {
        ClientAddressRS response = clientService.updateAddress(id, codeLocation, address);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/address/{codeLocation}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> removeAddress(@PathVariable("id") String id,
            @PathVariable("codeLocation") String codeLocation) {
        clientService.removeAddress(id, codeLocation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
