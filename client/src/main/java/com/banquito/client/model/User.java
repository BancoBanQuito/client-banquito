package com.banquito.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    String userName;
    String password;
    String type;
    String status;
    Date creationDate;
    Date lastLoginDate;
}
