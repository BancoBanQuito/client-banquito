package com.banquito.client.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.banquito.client.model.ClientPhone;

@Repository
public class PhoneRepository extends MongoRepository<ClientPhone, String> {

}
