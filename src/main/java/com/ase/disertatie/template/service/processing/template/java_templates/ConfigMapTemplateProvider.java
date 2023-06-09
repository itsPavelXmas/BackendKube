package com.ase.disertatie.template.service.processing.template.java_templates;

import com.ase.disertatie.template.data.InfrastructureTemplateRepository;
import com.ase.disertatie.template.domain.ComponentKind;
import com.ase.disertatie.template.service.processing.dto.SimpleFileDTO;
import com.ase.disertatie.template.service.processing.dto.concretes.ConfigMapDto;
import com.ase.disertatie.template.service.processing.dto.concretes.IngressDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.ase.disertatie.template.service.processing.utils.InfrastructureConstants.*;

@Component
@RequiredArgsConstructor
public class ConfigMapTemplateProvider {

    private final InfrastructureTemplateRepository templateRepository;

    public SimpleFileDTO populateConfigMap(ConfigMapDto configMapDto){
        var configMapTemplate =
                templateRepository.findByKind(ComponentKind.CONFIGMAP);
        var configmap = configMapTemplate.getContent();
        configmap = configmap.replace("cfgName",configMapDto.getName());
        configmap = configmap.replace("cfgData",configMapDto.getData());

        return new SimpleFileDTO(ComponentKind.CONFIGMAP.getName()+ FILE_EXTENSION,configmap);
    }
}
