package com.banquito.client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.banquito.client.controller.dto.PersonalClientDataRSRQ;
import com.banquito.client.controller.dto.SignatureRQ;
import com.banquito.client.controller.dto.UpdateAdressRQ;
import com.banquito.client.controller.dto.UpdateClientRQ;
import com.banquito.client.controller.dto.UpdatePhoneRQ;
import com.banquito.client.controller.dto.UpdateReferenceRQ;
import com.banquito.client.controller.dto.UserLogin;
import com.banquito.client.controller.dto.UserRQ;
import com.banquito.client.controller.mapper.ClientMapper;
import com.banquito.client.model.Client;
import com.banquito.client.service.ClientService;

@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*", methods = { 
    org.springframework.web.bind.annotation.RequestMethod.GET,
    org.springframework.web.bind.annotation.RequestMethod.POST,
    org.springframework.web.bind.annotation.RequestMethod.PUT,
    org.springframework.web.bind.annotation.RequestMethod.DELETE })
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{idCliente}/{identificationType}")
    public ResponseEntity<ClientRS> getClientById(@PathVariable("idCliente") String id,
                                                    @PathVariable("identificationType") String identificationType) {
        Client client = this.clientService.findClientByTypeIdAndID(identificationType, id);
        if (client != null) {
            return ResponseEntity.ok(ClientMapper.toClientRS(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "atm/{idCliente}")
    public ResponseEntity<Client> getClientById(@PathVariable("idCliente") String id) {
        Client client = this.clientService.findClientById(id);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/client/{idCliente}")
    public ResponseEntity<PersonalClientDataRSRQ> getPersoanlDataClientById(@PathVariable("idCliente") String id) {
        Client client = this.clientService.findClientById(id);
        if (client != null) {
            return ResponseEntity.ok(ClientMapper.toPersonalDataClient(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/clients/{lastname}")
    public ResponseEntity<List<Client>> getClientByLastName(@PathVariable("lastname") String lastname) {
        List<Client> client = this.clientService.findClientBySimilarLastname(lastname);
        if (client != null) {
            return ResponseEntity.ok(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "signature/{identificationType}/{identification}")
    public ResponseEntity<SignatureRQ> getSignature(@PathVariable("identificationType") String identificationType,
                                                    @PathVariable("identification") String identification){
        Client client = this.clientService.findClientByTypeIdAndID(identificationType,identification);
        if (client != null){
            return ResponseEntity.ok(ClientMapper.toSignature(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody NewClientRQ clientRQ) {
        try {
            Client savedClient = this.clientService.createClient(ClientMapper.toNewClient(clientRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/user/{idCliente}")
    public ResponseEntity<String> updateClientLikeBankUser(@PathVariable("idCliente") String id,
            @RequestBody UpdateClientRQ clientRQ) {
        try {
            this.clientService.updateClientLikeBankUser(id, clientRQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{idCliente}")
    public ResponseEntity<String> updateClient(@PathVariable("idCliente") String id, @RequestBody ClientRQ clientRQ) {
        try {
            this.clientService.updateClient(id, ClientMapper.toClient(clientRQ));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/phone")
    public ResponseEntity<String> updateClientPhone(@RequestBody UpdatePhoneRQ phoneRQ) {
        try {
            this.clientService.updatePhone(phoneRQ.getIdentificationType(), phoneRQ.getIdentification(),
                    phoneRQ.getPhone());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/reference")
    public ResponseEntity<String> updateClientReference(@RequestBody UpdateReferenceRQ referenceRQ) {
        try {
            this.clientService.updateReference(referenceRQ.getIdentificationType(), referenceRQ.getIdentification(),
                    referenceRQ.getReference());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/adress")
    public ResponseEntity<String> updateClientAdress(@RequestBody UpdateAdressRQ adressRQ) {
        try {
            this.clientService.updateAdress(adressRQ.getIdentificationType(), adressRQ.getIdentification(),
                    adressRQ.getAddress());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<UserRQ> singUp(@RequestBody UserRQ newUser) {
        Client client = clientService.singUp(ClientMapper.userToClient(newUser));
        if (client != null){
            return ResponseEntity.ok(ClientMapper.toUser(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserRQ> login(@RequestBody UserLogin user) {
        Client client = clientService.login(user);
        if (client != null){
            return ResponseEntity.ok(ClientMapper.toUser(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<PersonalClientDataRSRQ> getPersonalDataClientByEmail(@PathVariable("email") String email) {
        Client client = this.clientService.findClientByEmail(email);
        if (client != null) {
            return ResponseEntity.ok(ClientMapper.toPersonalDataClient(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
    @PutMapping(value = "/personal-data")
    public ResponseEntity<String> updatePersonalDataClient(@RequestBody PersonalClientDataRSRQ clientRQ) {
        try {
            this.clientService.updatePersoanlDataClient(clientRQ);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("OK");
    }
}
