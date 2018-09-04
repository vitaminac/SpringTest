package com.core.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Video { // TODO: AuditModel
    @Id
    @GeneratedValue(strategy = IDENTITY) // https://stackoverflow.com/a/4979988/9980245
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploader")
    @JsonIgnore
    private User uploader;

    @Column
    private String name;
}
