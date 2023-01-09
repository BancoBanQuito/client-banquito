package com.banquito.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.client.model.Client;
import com.banquito.client.repository.ClientRepository;

@Service
public class ClientService {
    
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    // ejemplo de lo que falta
    // @Transactional
    // public void deposit() {
    // }
}
