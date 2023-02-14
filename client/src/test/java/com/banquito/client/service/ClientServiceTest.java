package com.banquito.client.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.client.controller.dto.UpdateClientRQ;
import com.banquito.client.controller.mapper.ClientMapper;
import com.banquito.client.mock.ClientMock;
import com.banquito.client.model.Client;
import com.banquito.client.repository.ClientRepository;

@SpringBootTest
public class ClientServiceTest {
    
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
	private ClientService clientService;

    private final ClientMock clientMock = new ClientMock();

    @Test
    public void testUpdateClientLikeBankUser() {
        //Data to test
        UpdateClientRQ updateClientRQ = clientMock.createUpdateClientRQ();
        Client client = ClientMapper.updateClientRQtoClient(updateClientRQ);
        String id = "1";

        //mock injects
        when(clientRepository.existsByIdentification(id)).thenReturn(true);
        when(clientRepository.findByIdentification(id)).thenReturn(client);

        clientService.updateClientLikeBankUser(id, updateClientRQ);

        verify(clientRepository, times(1)).existsByIdentification(id);
		verify(clientRepository, times(1)).findByIdentification(id);
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    public void testUpdateClient(){
        //Data to test
        Client client = clientMock.createClient();
        String id = "1";

        //mock injects
        when(clientRepository.existsByIdentification(id)).thenReturn(true);
        when(clientRepository.findByIdentification(id)).thenReturn(client);

        clientService.updateClient(id, client);

        verify(clientRepository, times(1)).existsByIdentification(id);
		verify(clientRepository, times(1)).findByIdentification(id);
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    public void testDeleteClientByIdentification(){
        //Data to test
        Client client = clientMock.createClient();
        Client expected = client;
        //mock injects
        when(clientRepository.existsByIdentification(client.getIdentification())).thenReturn(true);
        when(clientRepository.findByIdentification(client.getIdentification())).thenReturn(client);

        Client result = clientService.deleteClientByIdentification(client);

        verify(clientRepository, times(1)).existsByIdentification(client.getIdentification());
		verify(clientRepository, times(1)).findByIdentification(client.getIdentification());
        verify(clientRepository, times(1)).save(client);
        assertEquals(expected, result);
    }

    @Test
    public void testGetidentificationTypeAndIdentification(){
        //Data to test
        Client client = clientMock.createClient();
        String id = "1720744943";
        Client expected = client;

        //mock injects
        when(clientRepository.findByIdentification(client.getIdentification())).thenReturn(client);

        Client result = clientService.getidentificationTypeAndIdentification(id);
        
        verify(clientRepository, times(1)).findByIdentification(id);
        assertEquals(expected, result);
    }

}
