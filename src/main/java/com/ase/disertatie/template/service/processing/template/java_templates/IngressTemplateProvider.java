package com.ase.disertatie.template.service.processing.template.java_templates;


import com.ase.disertatie.template.data.InfrastructureTemplateRepository;
import com.ase.disertatie.template.domain.ComponentKind;
import com.ase.disertatie.template.service.processing.dto.SimpleFileDTO;
import com.ase.disertatie.template.service.processing.dto.concretes.IngressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.ase.disertatie.template.service.processing.utils.InfrastructureConstants.*;

@Component
@RequiredArgsConstructor
public class IngressTemplateProvider {

    private final InfrastructureTemplateRepository templateRepository;

    public SimpleFileDTO populateIngressFile(IngressDTO ingressDTO){
        var ingressTemplate =
                templateRepository.findByKind(ComponentKind.INGRESS);
        var ingressFile = ingressTemplate.getContent();
        ingressFile = ingressFile.replace(COMPONENT_NAME,ingressDTO.getName());
        ingressFile = ingressFile.replace(HOST,ingressDTO.getHost());
        ingressFile = ingressFile.replace(PATH_TYPE,ingressDTO.getPathType());
        ingressFile = ingressFile.replace(PATH,ingressDTO.getPath());
        ingressFile = ingressFile.replace(SERVICE_NAME,ingressDTO.getServiceName());
        ingressFile = ingressFile.replace(PORT,ingressDTO.getPort());

        return new SimpleFileDTO(ComponentKind.INGRESS.getName()+ FILE_EXTENSION,ingressFile);
    }
}
