package com.ase.disertatie.template.service.processing.dto.concretes;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;

@Immutable
@Getter
@Setter
public class InfrastructureDTO {
    private DeploymentDTO deployment;
    private IngressDTO ingress;
    private SvcDTO svc;
    private HorizontalPodAutoscalerDTO hpa;
    private ConfigMapDto configMap;
}
