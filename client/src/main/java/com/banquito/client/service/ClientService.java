package com.banquito.client.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.client.controller.dto.UpdateClientRQ;
import com.banquito.client.controller.dto.UserLogin;
import com.banquito.client.model.Client;
import com.banquito.client.model.ClientAddress;
import com.banquito.client.model.ClientPhone;
import com.banquito.client.model.ClientReference;

import com.banquito.client.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findClientById(String id) {
        Boolean clientExists = this.clientRepository.existsByIdentification(id);
        if (!clientExists) {
            throw new RuntimeException("The client does not exist");
        }
        return this.clientRepository.findByIdentification(id);
    }

    public Client findClientByTypeIdAndID(String typeId, String id){
        Boolean clientExists = this.clientRepository.existsByIdentification(id);
        if (!clientExists){
            throw new RuntimeException("The client does not exist");
        }
        return this.clientRepository.findByIdentificationTypeAndIdentification(typeId, id);        
    }

    @Transactional
    public void createClient(Client client) {
        Boolean clientExists = this.clientRepository.existsByIdentification(client.getIdentification());
        if (clientExists) {
            throw new RuntimeException("The client already exists");
        }

        if (!isLegal(client.getBirthDate())) {
            throw new RuntimeException(
                    "The date of birth cannot be greater than the current date" + client.getBirthDate());
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

        if (!adressToUpdate.isPresent()) {
            clientToUpdate.getAddress().add(client.getAddress());
        }

        Optional<ClientPhone> phoneToUpdate = clientToUpdate.getPhone().stream()
                .filter(p -> p.equals(client.getPhone()))
                .findFirst();

        if (!phoneToUpdate.isPresent()) {
            clientToUpdate.getPhone().add(client.getPhone());
        }

        Optional<ClientReference> referenceToUpdate = clientToUpdate.getReference().stream()
                .filter(p -> p.equals(client.getReference()))
                .findFirst();

        if (!referenceToUpdate.isPresent()) {
            clientToUpdate.getReference().add(client.getReference());
        }

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
        if (adressToUpdate.get(0).getLatitude().equals(client.getAddress().get(0).getLatitude()) &&
                adressToUpdate.get(0).getLongitude().equals(client.getAddress().get(0).getLongitude()) &&
                adressToUpdate.get(0).getLineOne().equals(client.getAddress().get(0).getLineOne()) &&
                adressToUpdate.get(0).getLineTwo().equals(client.getAddress().get(0).getLineTwo())) {
            throw new RuntimeException("Adress " + adressToUpdate.get(0).getCodeLocation() + " already exist");
        }
        clientToUpdate.setAddress(client.getAddress());

        List<ClientPhone> phoneToUpdate = this.clientRepository.findByPhonePhoneNumber(
                clientToUpdate.getPhone().get(0).getPhoneNumber());
        if (phoneToUpdate.get(0).getPhoneNumber().equals(client.getPhone().get(0).getPhoneNumber()) &&
                phoneToUpdate.get(0).getPhoneType().equals(client.getPhone().get(0).getPhoneType())) {
            throw new RuntimeException("The phone " + phoneToUpdate.get(0).getPhoneNumber() + " already exist");
        }
        clientToUpdate.setPhone(client.getPhone());

        this.clientRepository.save(clientToUpdate);
    }

    @Transactional
    public Client deleteClientByIdentification(Client client) {
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
    public Client getTypeIdentificationAndIdentification(String identification) {
        return this.clientRepository.findByIdentification(identification);
    }

    @Transactional
    public List<Client> findClientBySimilarLastname(String lastname) {
        return this.clientRepository.findByLastnameLikeOrderByLastname(lastname);
    }

    @Transactional
    public void updatePhone(String identificationType, String identification, ClientPhone phone) {

        Boolean clientExists = this.clientRepository.existsByIdentificationTypeAndIdentification(identificationType,
                identification);
        if (!clientExists) {
            throw new RuntimeException("The client does not exist");
        }
        Client clientToUpdate = this.clientRepository.findByIdentificationTypeAndIdentification(identificationType,
                identification);
        Optional<ClientPhone> phoneToUpdate = clientToUpdate.getPhone().stream()
                .filter(p -> p.equals(phone))
                .findFirst();

        if (!phoneToUpdate.isPresent()) {
            clientToUpdate.getPhone().add(phone);
            this.clientRepository.save(clientToUpdate);
        }

    }

    @Transactional
    public void updateAdress(String identificationType, String identification, ClientAddress adress) {

        Boolean clientExists = this.clientRepository.existsByIdentificationTypeAndIdentification(identificationType,
                identification);
        if (!clientExists) {
            throw new RuntimeException("The client does not exist");
        }
        Client clientToUpdate = this.clientRepository.findByIdentificationTypeAndIdentification(identificationType,
                identification);
        Optional<ClientAddress> adressToUpdate = clientToUpdate.getAddress().stream()
                .filter(p -> p.equals(adress))
                .findFirst();

        if (!adressToUpdate.isPresent()) {
            clientToUpdate.getAddress().add(adress);
            this.clientRepository.save(clientToUpdate);
        }

    }

    @Transactional
    public void updateReference(String identificationType, String identification, ClientReference reference) {

        Boolean clientExists = this.clientRepository.existsByIdentificationTypeAndIdentification(identificationType,
                identification);
        if (!clientExists) {
            throw new RuntimeException("The client does not exist");
        }
        Client clientToUpdate = this.clientRepository.findByIdentificationTypeAndIdentification(identificationType,
                identification);
        Optional<ClientReference> referenceToUpdate = clientToUpdate.getReference().stream()
                .filter(p -> p.equals(reference))
                .findFirst();

        if (!referenceToUpdate.isPresent()) {
            clientToUpdate.getReference().add(reference);
            this.clientRepository.save(clientToUpdate);
        }

    }
    /*
     * public boolean isLegal(Date date) {
     * Date actualDate = new Date();
     * int age = actualDate.getYear() - date.getYear();
     * return age > 18;
     * }
     */

    public boolean isLegal(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date can not be null");
        }
        LocalDate birthdate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        Period age = Period.between(birthdate, now);
        return age.getYears() > 18;
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
        Client registeredClient = this.clientRepository.findByIdentificationTypeAndIdentification(client.getIdentificationType(), client.getIdentification());
        if(registeredClient != null && registeredClient.getEmail().equals(client.getUser().getUserName()) 
            && registeredClient.getUser() == null
        ){
            registeredClient.setUser(client.getUser());
            this.clientRepository.save(registeredClient);
            return true;
        }
        return false;
    }

}
