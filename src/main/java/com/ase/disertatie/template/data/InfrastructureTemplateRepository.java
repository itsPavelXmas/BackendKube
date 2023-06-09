package com.ase.disertatie.template.data;

import com.ase.disertatie.template.domain.ComponentKind;
import com.ase.disertatie.template.domain.InfrastructureTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfrastructureTemplateRepository
        extends JpaRepository<InfrastructureTemplate, Long> {
    InfrastructureTemplate findByKind(ComponentKind kind);
}
