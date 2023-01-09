package com.banquito.client.service;

import org.springframework.stereotype.Service;

import com.banquito.client.repository.RelationshipRepository;

@Service
public class RelationshipService {
    private final RelationshipRepository relationshipRepository;

    public RelationshipService(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    public void create() {
    }

    public void update() {
    }
}
