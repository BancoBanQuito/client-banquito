package com.banquito.client.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.client.controller.dto.ClientRQ;
import com.banquito.client.controller.dto.UpdateClientRQ;
import com.banquito.client.controller.dto.UserLogin;
import com.banquito.client.model.Client;
import com.banquito.client.model.ClientAddress;
import com.banquito.client.model.ClientPhone;
import com.banquito.client.model.ClientReference; 
import com.banquito.client.model.User;
import com.banquito.client.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client findClientById(String id, String identificationType){
        Boolean clientExists = this.clientRepository.existsByIdentification(id);
        if (!clientExists){
            throw new RuntimeException("The client does not exist");
        }
        return this.clientRepository.findByIdentificationAndIdentificationType(id, identificationType);
    }

    @Transactional
    public void createClient(Client client){
        Boolean clientExists = this.clientRepository.existsByIdentification(client.getIdentification());
        if(clientExists){
            throw new RuntimeException("The client already exists");
        }

        if (!isLegal(client.getBirthDate())){
            throw new RuntimeException("The date of birth cannot be greater than the current date" + client.getBirthDate());
        }

        client.setFullname(client.getLastname() + " " + client.getFirstname());
        client.setStatus("INA");
        client.setCreationDate(new Date());
        this.clientRepository.save(client);
    }

    @Transactional
    public void updateClientLikeBankUser(String id, UpdateClientRQ client) {
        Boolean clientExists = this.clientRepository.existsByIdentification(id);
        if (!clientExists) {
            throw new RuntimeException("Client not found");
        }
        Client clientToUpdate = this.clientRepository.findByIdentificationAndIdentificationType(id, client.getIdentificationType());

        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setGender(client.getGender());
        clientToUpdate.setCompanyName(client.getCompanyName());
        clientToUpdate.setCompanyType(client.getCompanyType());
        clientToUpdate.setWorkStatus(client.getWorkStatus());
        clientToUpdate.setAppLegalRepresent(client.getAppLegalRepresent());
        clientToUpdate.setArticlesAssociatedDoc(client.getArticlesAssociatedDoc());
        clientToUpdate.setBasicServicesDocument(client.getBasicServicesDocument());
        clientToUpdate.setCareer(client.getCareer());
        clientToUpdate.setCreateDateCompany(client.getCreateDateCompany());
        clientToUpdate.setMaritalStatus(client.getMaritalStatus());
        clientToUpdate.setMonthlyAvgIncome(client.getMonthlyAvgIncome());
        clientToUpdate.setNationality(client.getNationality());
        clientToUpdate.setSignature(client.getSignature());
        clientToUpdate.setTaxPaymentPlace(client.getTaxPaymentPlace());

        Optional<ClientAddress> adressToUpdate = clientToUpdate.getAddress().stream()
                                            .filter(p -> p.equals(client.getAddress()))
                                            .findFirst();

        if(!adressToUpdate.isPresent()){
            clientToUpdate.getAddress().add(client.getAddress());
        }

        /*Optional<ClientSegment> segmentToUpdate = clientToUpdate.getSegment().stream()
                                                .filter(p -> p.equals(client.getSegment()))
                                                .findFirst();

        if(!segmentToUpdate.isPresent()){
            clientToUpdate.getSegment().add(client.getSegment());
        }/* */

        Optional<ClientPhone> phoneToUpdate = clientToUpdate.getPhone().stream()
                                            .filter(p -> p.equals(client.getPhone()))
                                            .findFirst();
        
        if(!phoneToUpdate.isPresent()){
            clientToUpdate.getPhone().add(client.getPhone());
        }                                  

        Optional<ClientReference> referenceToUpdate = clientToUpdate.getReference().stream()
                                                    .filter(p -> p.equals(client.getReference()))
                                                    .findFirst();

        if(!referenceToUpdate.isPresent()){
            clientToUpdate.getReference().add(client.getReference());
        }

        this.clientRepository.save(clientToUpdate);
    }

    @Transactional
    public void updateClient(String id, ClientRQ client) {
        Boolean clientExists = this.clientRepository.existsByIdentification(id);
        if (!clientExists) {
            throw new RuntimeException("Client not found");
        }
        Client clientToUpdate = this.clientRepository.findByIdentificationAndIdentificationType(id, client.getIdentificationType());

        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setGender(client.getGender());
        clientToUpdate.setCareer(client.getCareer());

        Optional<ClientAddress> adressToUpdate = clientToUpdate.getAddress().stream()
                                            .filter(p -> p.equals(client.getAddress()))
                                            .findFirst();

        if(!adressToUpdate.isPresent()){
            clientToUpdate.getAddress().add(client.getAddress());
        }

        Optional<ClientPhone> phoneToUpdate = clientToUpdate.getPhone().stream()
                                            .filter(p -> p.equals(client.getPhone()))
                                            .findFirst();
        
        if(!phoneToUpdate.isPresent()){
            clientToUpdate.getPhone().add(client.getPhone());
        }                                  

        this.clientRepository.save(clientToUpdate);
    }

    public boolean login(UserLogin user){
        Client registeredClient = this.clientRepository.findByEmail(user.getUserName());
        System.out.println(registeredClient);
        if(
            //registeredClient != null && registeredClient.getEmail().equals(user.getUserName())
            registeredClient.getUser().getUserName().equals(user.getUserName())
            && registeredClient.getUser().getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }

    public boolean singUp(Client client){
        Client registeredClient = getTypeIdentificationAndIdentification(client.getIdentification(), client.getIdentificationType());
        if(registeredClient != null && registeredClient.getEmail().equals(client.getUser().getUserName()) 
            && registeredClient.getUser() == null
        ){
            registeredClient.setUser(client.getUser());
            this.clientRepository.save(registeredClient);
            return true;
        }
        return false;
    }

    @Transactional
    public Client deleteClientByIdentification(Client client){
        Boolean clientExists = this.clientRepository.existsByIdentification(client.getIdentification());
        if (!clientExists) {
            throw new RuntimeException("Client not found");
        }
        Client clientToUpdate = this.clientRepository.findByIdentificationAndIdentificationType(client.getIdentification(), client.getIdentificationType());
            clientToUpdate.setStatus(client.getStatus());
            clientToUpdate.setLastStatusDate(client.getLastStatusDate());
            this.clientRepository.save(clientToUpdate);
            return clientToUpdate;
    }

    @Transactional
    public Client getTypeIdentificationAndIdentification(String identification , String identificationType){
        return this.clientRepository.findByIdentificationAndIdentificationType(identification, identificationType);
    }

    @Transactional
    public List<Client> findClientBySimilarLastname(String lastname){
        return this.clientRepository.findByLastnameLikeOrderByLastname(lastname);
    }

    public boolean isLegal(Date date){
        Date actualDate = new Date();
        int age = actualDate.getYear()-date.getYear();
        return age > 18;
    }
}
