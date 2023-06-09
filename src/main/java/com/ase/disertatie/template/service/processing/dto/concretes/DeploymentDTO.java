package com.ase.disertatie.template.service.processing.dto.concretes;

import com.ase.disertatie.template.domain.ComponentKind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Immutable
@Getter
@AllArgsConstructor
public class DeploymentDTO {
    private static final ComponentKind KIND = ComponentKind.DEPLOYMENT;
    private String labelName;
    private Integer replicas;
    private Integer containerPort;
    private String imageName;
    private String name;
    private String containerName;
    private String namespace;
    private String memory;
    private String cpu;
    private String cpuLimit;
    private String memoryLimit;
    private String portName;
}
