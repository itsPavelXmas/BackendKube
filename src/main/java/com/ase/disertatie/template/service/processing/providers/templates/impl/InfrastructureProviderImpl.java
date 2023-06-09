package com.ase.disertatie.template.service.processing.providers.templates.impl;



import com.ase.disertatie.template.data.AuditRepository;
import com.ase.disertatie.template.domain.Audit;
import com.ase.disertatie.template.domain.ComponentKind;
import com.ase.disertatie.template.service.processing.dto.SimpleFileDTO;
import com.ase.disertatie.template.service.processing.dto.concretes.InfrastructureDTO;
import com.ase.disertatie.template.service.processing.providers.templates.InfrastructureProvider;
import com.ase.disertatie.template.service.processing.template.java_templates.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InfrastructureProviderImpl implements InfrastructureProvider {

    private final DeploymentTemplateProvider deploymentTemplateProvider;
    private final SvcTemplateProvider svcTemplateProvider;
    private final HpaTemplateProvider hpaTemplateProvider;
    private final IngressTemplateProvider ingressTemplateProvider;
    private final ConfigMapTemplateProvider configMapTemplateProvider;
    private final AuditRepository auditRepository;

    @Override
    public List<SimpleFileDTO> provideInfrastructureFiles(final InfrastructureDTO infrastructureDTO) {
        var infrastructureFiles = new ArrayList<SimpleFileDTO>();
        var deployment = deploymentTemplateProvider.populateDeploymentFile(infrastructureDTO.getDeployment());
        var svc = svcTemplateProvider.populateSvcFile(infrastructureDTO.getSvc());
        var hpa = hpaTemplateProvider.populateHpaFile(infrastructureDTO.getHpa());
        var ingress = ingressTemplateProvider.populateIngressFile(infrastructureDTO.getIngress());
       infrastructureFiles.add(deployment);
        infrastructureFiles.add(svc);
        infrastructureFiles.add(hpa);
        infrastructureFiles.add(ingress);
        return infrastructureFiles;
    }

    @Override
    public SimpleFileDTO provideInfrastructureFile(final InfrastructureDTO infrastructureDTO) {
       if(infrastructureDTO.getDeployment() != null){
          var deployment =  deploymentTemplateProvider.populateDeploymentFile(infrastructureDTO.getDeployment());
        saveToAudit(deployment,ComponentKind.DEPLOYMENT.getName());
        return deployment;
       }
        if(infrastructureDTO.getHpa() != null){
            var hpa =  hpaTemplateProvider.populateHpaFile(infrastructureDTO.getHpa());
            saveToAudit(hpa,ComponentKind.HPA.getName());
            return hpa;
        }
        if(infrastructureDTO.getSvc() != null){
            var svc =  svcTemplateProvider.populateSvcFile(infrastructureDTO.getSvc());
            saveToAudit(svc,ComponentKind.SVC.getName());
            return svc;
        }
        if(infrastructureDTO.getConfigMap() != null){
            var configMap = configMapTemplateProvider.populateConfigMap(infrastructureDTO.getConfigMap());
            saveToAudit(configMap,ComponentKind.CONFIGMAP.getName());
            return configMap;
        }

        var ingress = ingressTemplateProvider.populateIngressFile(infrastructureDTO.getIngress());
        saveToAudit(ingress,ComponentKind.INGRESS.getName());
        return ingress;
    }
    private void saveToAudit(SimpleFileDTO simpleFileDTO, String type){
        var audit = new Audit();
        audit.setType(type);
        audit.setGeneratedFileName(simpleFileDTO.getName());
        audit.setCreatedDate(new Date());
        auditRepository.save(audit);
    }

}
