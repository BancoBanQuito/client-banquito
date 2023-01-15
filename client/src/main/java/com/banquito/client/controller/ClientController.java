package com.banquito.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.client.controller.dto.ClientRQ;
import com.banquito.client.controller.dto.ClientRS;
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

    //obtener todos los clientes
    @GetMapping(value = "/all")
    public ResponseEntity<List<ClientRS>> allClients(){
        List<Client> clients = new ArrayList<>();
        Iterable<Client> clientsIterable = this.clientService.findAll();
        clientsIterable.forEach(clients::add);
        List<ClientRS> clientsRS = new ArrayList<>();
        for (Client client : clients) {
            clientsRS.add(ClientMapper.toClientRS(client));
        }
        return ResponseEntity.ok(clientsRS);
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

    //crear cliente
    @PostMapping(value = "/create")
    public ResponseEntity<String> createClient(@RequestBody ClientRQ clientRQ){
        try {
            this.clientService.createClient(ClientMapper.toClient(clientRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
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

    @RequestMapping(value = "/phone", method = RequestMethod.PUT)
    public Object updatePhone() {
        return ResponseEntity.status(200).body("Address update");
    }

}
