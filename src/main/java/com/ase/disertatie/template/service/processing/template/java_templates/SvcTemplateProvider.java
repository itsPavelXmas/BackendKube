package com.ase.disertatie.template.service.processing.template.java_templates;


import com.ase.disertatie.template.data.InfrastructureTemplateRepository;
import com.ase.disertatie.template.domain.ComponentKind;
import com.ase.disertatie.template.service.processing.dto.SimpleFileDTO;
import com.ase.disertatie.template.service.processing.dto.concretes.SvcDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.ase.disertatie.template.service.processing.utils.InfrastructureConstants.*;


@Component
@RequiredArgsConstructor
public class SvcTemplateProvider {

    private final InfrastructureTemplateRepository templateRepository;

    public SimpleFileDTO populateSvcFile(SvcDTO svcDTO){
        var svc =
                templateRepository.findByKind(ComponentKind.SVC);
        var serviceFile = svc.getContent();
        serviceFile = serviceFile.replace(COMPONENT_NAME,svcDTO.getName());
        serviceFile = serviceFile.replace(NAMESPACE_NAME,svcDTO.getNamespace());
        serviceFile = serviceFile.replace(LABEL_NAME,svcDTO.getLabelName());
        serviceFile = serviceFile.replace(TYPE, svcDTO.getType());
        serviceFile = serviceFile.replace(PORT_NAME, svcDTO.getProtocol());
        serviceFile = serviceFile.replace(TARGET_PORT, svcDTO.getTargetPort());
        serviceFile = serviceFile.replace(PORT, svcDTO.getPort());
        return new SimpleFileDTO(ComponentKind.SVC.getName()+ FILE_EXTENSION,serviceFile);
    }


}
