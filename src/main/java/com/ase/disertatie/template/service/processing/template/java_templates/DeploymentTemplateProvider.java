package com.ase.disertatie.template.service.processing.template.java_templates;



import com.ase.disertatie.template.data.InfrastructureTemplateRepository;
import com.ase.disertatie.template.domain.ComponentKind;
import com.ase.disertatie.template.service.processing.dto.SimpleFileDTO;
import com.ase.disertatie.template.service.processing.dto.concretes.DeploymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.ase.disertatie.template.service.processing.utils.InfrastructureConstants.*;


@Component
@RequiredArgsConstructor
public class DeploymentTemplateProvider {

    private final InfrastructureTemplateRepository templateRepository;

    public SimpleFileDTO populateDeploymentFile(DeploymentDTO deploymentDTO){
        var deployment =
                templateRepository.findByKind(ComponentKind.DEPLOYMENT);
        var deploymentFile = deployment.getContent();
        deploymentFile = deploymentFile.replace(DEPLOYMENT_NAME,deploymentDTO.getName());
        deploymentFile = deploymentFile.replace(REPLICA_NUMBER,deploymentDTO.getReplicas().toString());
        deploymentFile = deploymentFile.replace(IMAGE_NAME,deploymentDTO.getImageName());
        deploymentFile = deploymentFile.replace(CONTAINER_PORT,deploymentDTO.getContainerPort().toString());
        deploymentFile = deploymentFile.replace(CONTAINER_NAME,deploymentDTO.getContainerName());
        deploymentFile = deploymentFile.replace(LABEL_NAME,deploymentDTO.getLabelName());
        deploymentFile = deploymentFile.replace(NAMESPACE_NAME,deploymentDTO.getNamespace());
        deploymentFile = deploymentFile.replace(MEMORY_LIMIT,deploymentDTO.getMemoryLimit());
        deploymentFile = deploymentFile.replace(MEMORY,deploymentDTO.getMemory());
        deploymentFile = deploymentFile.replace(CPU_LIMIT,deploymentDTO.getCpuLimit());
        deploymentFile = deploymentFile.replace(CPU,deploymentDTO.getCpu());
        deploymentFile = deploymentFile.replace(PORT_NAME,deploymentDTO.getPortName());
        return new SimpleFileDTO(ComponentKind.DEPLOYMENT.getName() + FILE_EXTENSION,deploymentFile);
    }
}
