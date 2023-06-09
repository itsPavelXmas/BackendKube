package com.ase.disertatie.template.service.processing.dto.concretes;

import com.ase.disertatie.template.domain.ComponentKind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Immutable
@Getter
@AllArgsConstructor
public class IngressDTO {
    private static final ComponentKind KIND = ComponentKind.INGRESS;
    private String name;
    private String host;
    private String path;
    private String pathType;
    private String serviceName;
    private String port;
}
