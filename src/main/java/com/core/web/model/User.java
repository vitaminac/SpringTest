package com.core.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.core.web.util.PersistenceConstants.UserTableName;

@Entity
@Table(name = UserTableName)
@Data
public class User { // TODO: implement UserDetail and add column role
    @Id
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
