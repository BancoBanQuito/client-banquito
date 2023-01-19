package com.banquito.client.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Getter
@Component
public class ApplicationValues {
    public final String host;
    public final String username;
    public final String password;
    public final String database;

    public ApplicationValues(
            @Value("${mongo.host}") String host,
            @Value("${mongo.username}") String username,
            @Value("${mongo.password}") String password,
            @Value("${mongo.database}") String database) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.database = database;
    }
}
