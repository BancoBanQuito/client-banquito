package com.banquito.client.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.client.model.Client;
import com.banquito.client.model.ClientAddress;
import com.banquito.client.model.ClientPhone;
import com.banquito.client.model.ClientReference;
import com.banquito.client.model.ClientSegment;
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
        if(!clientExists){
            throw new RuntimeException("The client already exists");
        }

        if (client.getBirthDate().after(new Date())) {
            throw new RuntimeException("The date of birth cannot be greater than the current date" + client.getBirthDate());
        }

        client.setFullname(client.getLastname() + " " + client.getFirstname());
        client.setStatus("INA");
        client.setCreationDate(new Date());
        this.clientRepository.save(client);
    }

    @Transactional
    public void updateClientLikeBankUser(String id, Client client) {
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

        List<ClientAddress> adressToUpdate = this.clientRepository.findByAddressCodeLocation(
            clientToUpdate.getAddress().get(0).getCodeLocation());
        if(adressToUpdate.get(0).getLatitude().equals(client.getAddress().get(0).getLatitude()) &&            
            adressToUpdate.get(0).getLongitude().equals(client.getAddress().get(0).getLongitude()) &&
            adressToUpdate.get(0).getLineOne().equals(client.getAddress().get(0).getLineOne()) &&
            adressToUpdate.get(0).getLineTwo().equals(client.getAddress().get(0).getLineTwo())){
            throw new RuntimeException("Adress " + adressToUpdate.get(0).getCodeLocation() + " already exist");
        }
        clientToUpdate.setAddress(client.getAddress());

        List<ClientSegment> segmentToUpdate = this.clientRepository.findBySegmentCode(
            clientToUpdate.getAddress().get(0).getCodeLocation());
        if(segmentToUpdate.get(0).getName().equals(client.getSegment().get(0).getName()) &&
            segmentToUpdate.get(0).getStatus().equals(client.getSegment().get(0).getStatus())){
            throw new RuntimeException("Segment " + segmentToUpdate.get(0).getName() + " already exist");
        }
        clientToUpdate.setSegment(client.getSegment());

        List<ClientPhone> phoneToUpdate = this.clientRepository.findByPhonePhoneNumber(
            clientToUpdate.getPhone().get(0).getPhoneNumber());
        if(phoneToUpdate.get(0).getPhoneNumber().equals(client.getPhone().get(0).getPhoneNumber()) &&
        phoneToUpdate.get(0).getPhoneType().equals(client.getPhone().get(0).getPhoneType())){
            throw new RuntimeException("The phone " + phoneToUpdate.get(0).getPhoneNumber() + " already exist");
        }
        clientToUpdate.setPhone(client.getPhone());

        List<ClientReference> referenceToUpdate = this.clientRepository.findByReferenceName(
            clientToUpdate.getReference().get(0).getName());
        if(referenceToUpdate.get(0).getName().equals(client.getReference().get(0).getName()) &&
        referenceToUpdate.get(0).getPhone().equals(client.getReference().get(0).getPhone())){
            throw new RuntimeException("The reference " + referenceToUpdate.get(0).getName() + " already exist");
        }
        clientToUpdate.setReference(client.getReference());
        this.clientRepository.save(clientToUpdate);
    }

    @Transactional
    public void updateClient(String id, Client client) {
        Boolean clientExists = this.clientRepository.existsByIdentification(id);
        if (!clientExists) {
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
    public Client getTypeIdentificationAndIdentification(String identification ){
        return this.clientRepository.findByIdentification(identification);
    }

    @Transactional
    public List<Client> findClientBySimilarLastname(String lastname){
        return this.clientRepository.findByLastnameLikeOrderByLastname(lastname);
    }

}
