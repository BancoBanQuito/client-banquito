package com.banquito.client.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.banquito.client.model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    
}
