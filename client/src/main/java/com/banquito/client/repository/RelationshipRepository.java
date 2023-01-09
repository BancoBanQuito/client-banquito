package com.banquito.client.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banquito.client.model.ClientRelationship;

@Repository
public class RelationshipRepository extends MongoRepository<ClientRelationship, String> {

}
