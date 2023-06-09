package com.ase.disertatie.template.service.processing.providers.templates;


import com.ase.disertatie.template.service.processing.dto.SimpleFileDTO;
import com.ase.disertatie.template.service.processing.dto.concretes.InfrastructureDTO;

import java.util.List;

public interface InfrastructureProvider {
    List<SimpleFileDTO> provideInfrastructureFiles(final InfrastructureDTO infrastructureDTO);

    SimpleFileDTO provideInfrastructureFile(final InfrastructureDTO infrastructureDTO);
}
