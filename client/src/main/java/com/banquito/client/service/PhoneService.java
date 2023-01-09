package com.banquito.client.service;

import org.springframework.stereotype.Service;

import com.banquito.client.repository.PhoneRepository;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public void create() {
    }

    public void update() {
    }
}
