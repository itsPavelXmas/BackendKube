package com.ase.disertatie.template.service.processing.dto.concretes;

import com.ase.disertatie.template.domain.ComponentKind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Immutable
@Getter
@AllArgsConstructor
public class ConfigMapDto {
    private static final ComponentKind KIND = ComponentKind.CONFIGMAP;
    private String name;
    private String data;
}
