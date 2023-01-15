package com.banquito.client.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.client.model.Client;
import com.banquito.client.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    //buscar por ID
    public Client findById(String id){
        Optional<Client> clientOpt = this.clientRepository.findById(id);
        if (clientOpt.isPresent()){
            return clientOpt.get();
        } else {
            throw new RuntimeException("The client does not exist");
        }
    }

    //crear cliente
    public void createClient(Client client){
        client.setFullname(client.getLastname() + " " + client.getFirstname());
        if (client.getBirthDate().after(new Date())) {
            throw new RuntimeException("The date of birth cannot be greater than the current date" + client.getBirthDate());
        }
        client.setStatus("INA");
        client.setCreationDate(new Date());

        Client clienteTemp = this.clientRepository.findByIdentificationTypeAndIdentification(client.getIdentificationType(), client.getIdentification());
        if (clienteTemp != null){
            throw new RuntimeException("The client already exists");
        }
        this.clientRepository.save(client);
    }


//obtener por tipo de identificacion y numero de identificacion
    public Client getTypeIdentificationAndIdentification(String typeIdentification, String identification ){
        return this.clientRepository.findByIdentificationTypeAndIdentification(typeIdentification, identification);
    }

    //obtener todos
    public Iterable<Client> findAll(){
        log.info("Getting all customers");
        return this.clientRepository.findAll();
    }

    //obtener por apellidos
    public List<Client> getByLastname(String lastname){
        return this.clientRepository.findByLastnameOrderByLastname(lastname);
    }

    //obtener por nombres que contengan la cadena
    public List<Client> findByLastname(String lastname){
        return this.clientRepository.findByLastnameLikeOrderByLastname(lastname);
    }

    //buscar por estado
    public List<Client> findByStatus(String status){
        return this.clientRepository.findByStatusOrderByStatus(status);
    }

    //buscar por segmento
    public List<Client> findBySegment(String segment){
        return this.clientRepository.findBySegmentOrderByNameSegment(segment);
    }

    public void update(){
    }

    public void login(){
    }

    public void singUp(){
    }

    public void createReference() {
    }

    public void getReference() {
    }

    public void updateReference() {
    }

    public void createAddress() {
    }

    public void getAddress() {
    }

    public void updateAddress() {
    }

    public void updatePhone() {
    }
}
