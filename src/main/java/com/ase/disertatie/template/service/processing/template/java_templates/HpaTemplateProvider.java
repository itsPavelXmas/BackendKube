package com.ase.disertatie.template.service.processing.template.java_templates;

import com.ase.disertatie.template.data.InfrastructureTemplateRepository;
import com.ase.disertatie.template.domain.ComponentKind;
import com.ase.disertatie.template.service.processing.dto.SimpleFileDTO;
import com.ase.disertatie.template.service.processing.dto.concretes.HorizontalPodAutoscalerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.ase.disertatie.template.service.processing.utils.InfrastructureConstants.*;

@Component
@RequiredArgsConstructor
public class HpaTemplateProvider {
    private final InfrastructureTemplateRepository templateRepository;

    public SimpleFileDTO populateHpaFile(HorizontalPodAutoscalerDTO hpaDto){
        var hpaTemplate =
                templateRepository.findByKind(ComponentKind.HPA);
        var hpaFile = hpaTemplate.getContent();
        hpaFile = hpaFile.replace(COMPONENT_NAME,hpaDto.getName());
        hpaFile = hpaFile.replace(DEPLOYMENT_NAME,hpaDto.getDeploymentName());
        hpaFile = hpaFile.replace(MIN_REPLICAS,hpaDto.getMinReplicas());
        hpaFile = hpaFile.replace(MAX_REPLICAS,hpaDto.getMaxReplicas());
        hpaFile = hpaFile.replace(TYPE,hpaDto.getType());
        hpaFile = hpaFile.replace(CPU,hpaDto.getCpu());
        hpaFile = hpaFile.replace(AVG_UTIL,hpaDto.getAvgUtil());
        hpaFile = hpaFile.replace(UTIL_TYPE,hpaDto.getUtilType());

        return new SimpleFileDTO(ComponentKind.HPA.getName()+ FILE_EXTENSION,hpaFile);
    }
}
