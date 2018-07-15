package com.chat.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static com.chat.web.configuration.TableNameConstants.UserTableName;

@Entity
@Table(name = UserTableName)
public class User {
    @Id
    @Getter
    @Setter
    private String username;

    @JsonIgnore
    private String password;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
