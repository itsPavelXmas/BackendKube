package com.ase.disertatie.template.service.processing.dto.concretes;

import com.ase.disertatie.template.domain.ComponentKind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Immutable
@Getter
@AllArgsConstructor
public class HorizontalPodAutoscalerDTO {

    private static final ComponentKind KIND = ComponentKind.HPA;
    private String name;
    private String deploymentName;
    private String minReplicas;
    private String maxReplicas;
    private String type;
    private String cpu;
    private String utilType;
    private String avgUtil;



}
