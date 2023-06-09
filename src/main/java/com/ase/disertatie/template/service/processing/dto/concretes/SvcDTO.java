package com.ase.disertatie.template.service.processing.dto.concretes;


import com.ase.disertatie.template.domain.ComponentKind;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Immutable
@Getter
@AllArgsConstructor
public class SvcDTO {

    private static final ComponentKind KIND = ComponentKind.SVC;
    private String protocol;
    private String port;
    private String targetPort;
    private String namespace;
    private String labelName;
    private String type;
    private String name;

}
