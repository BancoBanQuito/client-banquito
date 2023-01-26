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
import com.banquito.client.controller.dto.PersonalClientDataRS;
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
@CrossOrigin(origins = "*", methods = { org.springframework.web.bind.annotation.RequestMethod.GET,
    org.springframework.web.bind.annotation.RequestMethod.POST,
    org.springframework.web.bind.annotation.RequestMethod.PUT,
    org.springframework.web.bind.annotation.RequestMethod.DELETE })
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{idCliente}/{typeIdentification}")
    public ResponseEntity<ClientRS> getClientById(@PathVariable("idCliente") String id,
                                                    @PathVariable("typeIdentification") String typeIdentification) {
        Client client = this.clientService.findClientByTypeIdAndID(typeIdentification, id);
        if (client != null) {
            return ResponseEntity.ok(ClientMapper.toClientRS(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/client/{idCliente}")
    public ResponseEntity<PersonalClientDataRS> getPersoanlDataClientById(@PathVariable("idCliente") String id) {
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

    @GetMapping(value = "signature/{typeIdentification}/{identification}")
    public ResponseEntity<SignatureRQ> getSignature(@PathVariable("typeIdentification") String typeIdentification,
                                                    @PathVariable("identification") String identification){
        Client client = this.clientService.findClientByTypeIdAndID(typeIdentification,identification);
        if (client != null){
            return ResponseEntity.ok(ClientMapper.toSignature(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createClient(@RequestBody NewClientRQ clientRQ) {
        try {
            this.clientService.createClient(ClientMapper.toNewClient(clientRQ));
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
    public ResponseEntity<String> singUp(@RequestBody UserRQ newUser) {
        try {
            boolean success = clientService.singUp(ClientMapper.userToClient(newUser));
            if (success) {
                return ResponseEntity.ok("User added successfully");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            System.out.print(e);
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(value = "/login")
    public Object login(@RequestBody UserLogin user) {
        try {
            boolean success = clientService.login(user);
            if (success) {
                return ResponseEntity.status(200).body("Client logged");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping(value = "/client/email/{email}")
    public ResponseEntity<PersonalClientDataRS> getPersoanlDataClientByEmail(@PathVariable("email") String email) {
        Client client = this.clientService.findClientByEmail(email);
        if (client != null) {
            return ResponseEntity.ok(ClientMapper.toPersonalDataClient(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
