package com.core.web.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import static javax.persistence.GenerationType.IDENTITY;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Data
public class Resource { // TODO: AuditModel
    @Id
    @GeneratedValue(strategy = IDENTITY) // https://stackoverflow.com/a/4979988/9980245
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String uri;
}
