package com.dev.leadBackEngineerTest.dto;

import java.util.UUID;

public class UserDTO {

    private UUID Id;
    private String FirstName;
    private String LastName;

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
