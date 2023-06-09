package com.ase.disertatie.template.service.processing.archive;

import com.ase.disertatie.template.service.processing.dto.concretes.InfrastructureDTO;

import java.util.List;

public interface ArchiveProcessor {
    byte[] createArchiveFromFiles(final InfrastructureDTO servicesData);

    byte[] createFileFromDTO(final InfrastructureDTO infrastructureDTO);
}
