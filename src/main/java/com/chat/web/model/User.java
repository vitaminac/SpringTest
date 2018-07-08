package com.chat.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @Getter
    @Setter
    private String email;

    @JsonIgnore
    @Getter
    @Setter
    private String password;
}
