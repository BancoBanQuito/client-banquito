package com.banquito.client.service;

import org.springframework.stereotype.Service;

import com.banquito.client.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public void create(){
    }

    public void update(){
    }

    public void login(){
    }

    public void singUp(){
    }

    public void createReference() {
    }

    public void getReference() {
    }

    public void updateReference() {
    }

    public void createAddress() {
    }

    public void getAddress() {
    }

    public void updateAddress() {
    }

    public void updatePhone() {
    }
}
