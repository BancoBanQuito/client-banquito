package com.banquito.client.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.banquito.client.model.Client;

public interface ClientRepository extends CrudRepository<Client, String>{  

    Client findByIdentificationTypeAndIdentification(String identificationType, String identification);

    List<Client> findByLastnameOrderByLastname(String lastname);
    List<Client> findByLastnameLikeOrderByLastname(String lastname);
    List<Client> findByStatusOrderByStatus(String status);
    List<Client> findBySegmentOrderByNameSegment(String segment);
    //preguntar si se hace un finby por los ingresos
}
