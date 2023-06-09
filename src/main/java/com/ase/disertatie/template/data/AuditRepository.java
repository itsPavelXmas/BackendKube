package com.ase.disertatie.template.data;

import com.ase.disertatie.template.domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository  extends JpaRepository<Audit, Long> {
}
