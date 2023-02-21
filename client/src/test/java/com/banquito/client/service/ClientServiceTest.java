package com.banquito.client.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.banquito.client.mock.NewClientMock;
import com.banquito.client.model.Client;
import com.banquito.client.repository.ClientRepository;

@SpringBootTest
public class ClientServiceTest {
    @Mock
	private ClientRepository clientRepositoryMock;

	@InjectMocks
	private ClientService clientServiceMock;

    @Test
	public void testCreateClient() {
		NewClientMock clientMock = new NewClientMock();
		Client newClient = clientMock.mockClient();
		when(clientServiceMock.createClient(newClient)).thenReturn(newClient);
        Client savedClient = clientServiceMock.createClient(newClient);
		verify(clientRepositoryMock, times(1)).save(newClient);
        assertEquals(newClient.getIdentification(), savedClient.getIdentification());
	}

    @Test
	public void testCreateClientWithAnExistingIdentification() {
        NewClientMock clientMock = new NewClientMock();
        Client newClient = clientMock.mockClient();
        when(clientServiceMock.createClient(newClient)).thenReturn(newClient);
        Client savedClient = clientServiceMock.createClient(newClient);
        verify(clientRepositoryMock, times(1)).save(newClient);

        when(clientServiceMock.createClient(newClient)).thenThrow(new RuntimeException("The client already exists"));
        Throwable exception = assertThrows(RuntimeException.class, () -> {
            clientServiceMock.createClient(newClient);
        });

        assertEquals("The client already exists", exception.getMessage());
	}

    @Test
	public void testCreateClientWithIlegalClient() {
		NewClientMock clientMock = new NewClientMock();
        Client newIlegalClient = clientMock.mockIlegalClient();

        Throwable exception = assertThrows(RuntimeException.class, () -> {
            clientServiceMock.createClient(newIlegalClient);
        });

        verify(clientRepositoryMock, never()).save(newIlegalClient);

        assertEquals("The date of birth cannot be greater than the current date" + newIlegalClient.getBirthDate(), exception.getMessage());
	}

}
