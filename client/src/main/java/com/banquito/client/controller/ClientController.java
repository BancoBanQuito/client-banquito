package com.banquito.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.client.model.Client;
import com.banquito.client.model.ClientPhone;
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

    // Phone Section
    @GetMapping("/{id}/phone")
    public List<ClientPhone> getPhones(@PathVariable String id) {
        Client client = clientService.findById(id);
        if (client != null)
            return client.getPhone();
        else
            return new ArrayList<>();
    }

    @PostMapping("/{id}/phone")
    public ResponseEntity<String> addPhone(@PathVariable String id, @RequestBody ClientPhone phone) {
        Client client = clientService.addPhone(id, phone);
        if (client != null)
            return new ResponseEntity<>("Phone added successfully", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Error adding phone", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}/phone/{phoneNumber}")
    public ResponseEntity<String> updatePhone(@PathVariable String id, @PathVariable String phoneNumber,
            @RequestBody ClientPhone phone) {
        Client client = clientService.updatePhone(id, phoneNumber, phone);
        if (client != null)
            return new ResponseEntity<>("Phone updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Error updating phone", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}/phone/{phoneNumber}")
    public ResponseEntity<String> removePhone(@PathVariable String id, @PathVariable String phoneNumber) {
        Client client = clientService.removePhone(id, phoneNumber);
        if (client != null)
            return new ResponseEntity<>("Phone removed successfully", HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>("Error removing phone", HttpStatus.BAD_REQUEST);
    }

}
