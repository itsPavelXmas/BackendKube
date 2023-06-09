package com.ase.disertatie.template.service.processing.archive.impl;


import com.ase.disertatie.template.service.processing.archive.ArchiveProcessor;
import com.ase.disertatie.template.service.processing.dto.SimpleFileDTO;
import com.ase.disertatie.template.service.processing.dto.concretes.InfrastructureDTO;
import com.ase.disertatie.template.service.processing.providers.templates.InfrastructureProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
@RequiredArgsConstructor
public class ArchiveProcessorImpl implements ArchiveProcessor {


    private final InfrastructureProvider infrastructureProvider;

    @Override
    public byte[] createArchiveFromFiles(final InfrastructureDTO serviceData) {
        var mainFileBytes = new ByteArrayOutputStream();
        try(var zip = new ZipOutputStream(mainFileBytes)){
                addFile(zip, "infrastructure.zip", createServiceArchive(serviceData));
            zip.closeEntry();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }

        return mainFileBytes.toByteArray();
    }

    private byte[] createServiceArchive(InfrastructureDTO serviceData) {
       var baos = new ByteArrayOutputStream();
        try(var zip = new ZipOutputStream(baos)) {
            addDirectory(zip, "/");
            var files = new ArrayList<SimpleFileDTO>(infrastructureProvider.provideInfrastructureFiles(serviceData));
            for(var simpleFileDTO : files) {
                addFile(zip, simpleFileDTO.getName(), simpleFileDTO.getContent());
            }
            zip.closeEntry();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return baos.toByteArray();
    }

    private void addFile(ZipOutputStream zip, String path, String content) throws IOException {
        addDirectory(zip, path);
        zip.write(content.getBytes(StandardCharsets.UTF_8));
    }
    private void addFile(ZipOutputStream zip, String path, byte[] content) throws IOException {
        addDirectory(zip, path);
        zip.write(content);
    }

    private void addDirectory(ZipOutputStream zip, String name) throws IOException {
        zip.putNextEntry(new ZipEntry(name));
    }


    @Override
    public byte[] createFileFromDTO(final InfrastructureDTO infrastructureDTO){
        var file = infrastructureProvider.provideInfrastructureFile(infrastructureDTO);
        return file.getContent().getBytes();

    }

}
