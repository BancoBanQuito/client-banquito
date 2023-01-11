package com.banquito.client.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.banquito.client.model.Client;

public interface ClientRepository extends CrudRepository<Client, String>{

    Client findByTypeIdentificationAndIdentification(String identificationType, String identification);

    List<Client> findByLastnameOrderByNames(String lastname);
    List<Client> findByLastnameLikeOrderByNames(String lastname);
    List<Client> findByStatusOrderByNames(String status);
    List<Client> findBySegmentOrderByNames(String segment);
}
