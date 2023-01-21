package com.banquito.client.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banquito.client.model.Client;
import com.banquito.client.model.ClientAddress;
import com.banquito.client.model.ClientPhone;
import com.banquito.client.model.ClientReference;
import com.banquito.client.model.ClientSegment;

@Repository
public interface ClientRepository extends CrudRepository<Client, String>{  

    Client findByIdentificationAndIdentificationType(String identification, String identificationType);
    Client findByIdentification(String identification);
    Client findByEmail(String email);
    Boolean existsByIdentification(String identification);
    List<Client> findByLastnameOrderByLastname(String lastname);
    List<Client> findByLastnameLikeOrderByLastname(String lastname);
    List<Client> findByStatusOrderByStatus(String status);
    List<ClientSegment> findBySegmentCode(String segment);
    List<ClientAddress> findByAddressCodeLocation(String address);
    List<ClientReference> findByReferenceName(String reference);
    List<ClientPhone> findByPhonePhoneNumber(String phone);
    List<Client> findByUserUserName(String email);
}
