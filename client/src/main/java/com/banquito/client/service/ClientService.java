package com.banquito.client.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.client.controller.dto.UpdateClientRQ;
import com.banquito.client.model.Client;
import com.banquito.client.model.ClientAddress;
import com.banquito.client.model.ClientPhone;
import com.banquito.client.model.ClientReference;
import com.banquito.client.model.ClientRelationship;
import com.banquito.client.model.ClientSegment;
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

    public Client findClientById(String id){
        Boolean clientExists = this.clientRepository.existsByIdentification(id);
        if (!clientExists){
            throw new RuntimeException("The client does not exist");
        }
        return this.clientRepository.findByIdentification(id);
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
        Client clientToUpdate = this.clientRepository.findByIdentification(id);

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
        clientToUpdate.setCreationDate(new Date());

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

        /*Optional<ClientRelationship> relationshipToUpdate = clientToUpdate.getRelationship().stream()
                                                    .filter(p -> p.equals(client.getRelationship()))
                                                    .findFirst();

        if(!relationshipToUpdate.isPresent()){
            clientToUpdate.getRelationship().add(client.getRelationship());
        }*/
        
        this.clientRepository.save(clientToUpdate);
    }

    @Transactional
    public void updateClient(String id, Client client) {
        Boolean clientExists = this.clientRepository.existsByIdentification(id);
        if (clientExists) {
            throw new RuntimeException("Client not found");
        }
        Client clientToUpdate = this.clientRepository.findByIdentification(id);

        clientToUpdate.setEmail(client.getEmail());
        clientToUpdate.setGender(client.getGender());
        
        List<ClientAddress> adressToUpdate = this.clientRepository.findByAddressCodeLocation(
            clientToUpdate.getAddress().get(0).getCodeLocation());
        if(adressToUpdate.get(0).getLatitude().equals(client.getAddress().get(0).getLatitude()) &&            
            adressToUpdate.get(0).getLongitude().equals(client.getAddress().get(0).getLongitude()) &&
            adressToUpdate.get(0).getLineOne().equals(client.getAddress().get(0).getLineOne()) &&
            adressToUpdate.get(0).getLineTwo().equals(client.getAddress().get(0).getLineTwo())){
            throw new RuntimeException("Adress " + adressToUpdate.get(0).getCodeLocation() + " already exist");
        }
        clientToUpdate.setAddress(client.getAddress());

        List<ClientPhone> phoneToUpdate = this.clientRepository.findByPhonePhoneNumber(
            clientToUpdate.getPhone().get(0).getPhoneNumber());
        if(phoneToUpdate.get(0).getPhoneNumber().equals(client.getPhone().get(0).getPhoneNumber()) &&
        phoneToUpdate.get(0).getPhoneType().equals(client.getPhone().get(0).getPhoneType())){
            throw new RuntimeException("The phone " + phoneToUpdate.get(0).getPhoneNumber() + " already exist");
        }
        clientToUpdate.setPhone(client.getPhone());

        this.clientRepository.save(clientToUpdate);
    }

    public void login(){

    }

    public boolean singUp(String typeIdentification, String identification,String email, User newUser){
        Client client = getTypeIdentificationAndIdentification(typeIdentification, identification);
        if(client!=null && client.getEmail().equals(email)){
            Optional<User> resultClient = client.getUser().stream()
                                    .filter(user -> user.getType().equals("cli"))
                                    .findFirst();
            
            if(!resultClient.isPresent()){
                boolean success = client.getUser().add(newUser);
                return success;
            }
            else{
                throw new RuntimeException("The user already exists");
            }
        }
        return false;
    }

    @Transactional
    public Client deleteClientByIdentification(Client client){
        Boolean clientExists = this.clientRepository.existsByIdentification(client.getIdentification());
        if (!clientExists) {
            throw new RuntimeException("Client not found");
        }
        Client clientToUpdate = this.clientRepository.findByIdentification(client.getIdentification());
            clientToUpdate.setStatus(client.getStatus());
            clientToUpdate.setLastStatusDate(client.getLastStatusDate());
            this.clientRepository.save(clientToUpdate);
            return clientToUpdate;
    }

    @Transactional
    public Client getTypeIdentificationAndIdentification(String identification , String identificationType){
        return this.clientRepository.findByIdentification(identification, identificationTyoe);
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
