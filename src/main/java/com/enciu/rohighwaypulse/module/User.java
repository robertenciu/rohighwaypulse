package com.enciu.rohighwaypulse.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private Date registrationDate;
}
