package com.ase.disertatie.template.resource;


import com.ase.disertatie.template.data.AuditRepository;
import com.ase.disertatie.template.service.processing.archive.ArchiveProcessor;
import com.ase.disertatie.template.service.processing.dto.concretes.InfrastructureDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/archive/")
public class ArchiveResource {


  private final ArchiveProcessor archiveProcessor;
  private final AuditRepository auditRepository;


    @PostMapping ("/generate")
    public byte[] getService(@RequestBody InfrastructureDTO servicesData) {
        return archiveProcessor.createFileFromDTO(servicesData);
    }

    @GetMapping("/history")
    public ResponseEntity getHistory() {
        var audit = auditRepository.findAll();
        return ResponseEntity.ok().body(audit);
    }

}
