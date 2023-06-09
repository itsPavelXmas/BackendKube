package com.ase.disertatie.template.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "infrastructure_template")
public class InfrastructureTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="kind")
    @Enumerated(EnumType.STRING)
    private ComponentKind kind;

    @Column(name="content", length = 100000)
    private String content;
}
