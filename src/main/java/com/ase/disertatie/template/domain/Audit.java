package com.ase.disertatie.template.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "generated_file_name")
    private String generatedFileName;

    @Column(name = "type")
    private String type;

    @Column(name = "created_date")
    private Date createdDate;

}
