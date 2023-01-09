package com.banquito.client.service;

import org.springframework.stereotype.Service;

import com.banquito.client.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    //4.1 Gestión de Clientes del Banco
    public void create(){
    }

    //4.1 Gestión de Clientes del Banco
    //4.2 Gestión de clientes desde la banca web. 
    public void update(){
    }

    //1.1 Registro de cliente en la banca web 
    public void login(){
    }

    //1.2 Inicio de Sesión Cliente 
    public void singUp(){
    }

     /**************
     * REFERENCE
    ***************/
    public void createReference() {
    }

    public void getReference() {
    }

    public void updateReference() {
    }
    
    /**************
     * ADDRESS
    ***************/
    public void createAddress() {
    }

    public void getAddress() {
    }

    public void updateAddress() {
    }


    /**************
     * PHONE
    ***************/
    public void updatePhone() {
    }
}
