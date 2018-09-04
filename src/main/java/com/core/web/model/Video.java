package com.core.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class Video { // TODO: AuditModel
    @Id
    // @GeneratedValue TODO: fix this
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploader")
    @JsonIgnore
    private User uploader;

    @Column
    private String name;
}
