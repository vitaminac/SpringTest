package com.core.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Video { // TODO: AuditModel
    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uploader")
    @JsonIgnore
    private User uploader;

    @Column
    private String name;
}
