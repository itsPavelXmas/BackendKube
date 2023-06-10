package com.ase.disertatie;


import com.ase.disertatie.template.data.InfrastructureTemplateRepository;
import com.ase.disertatie.template.domain.ComponentKind;
import com.ase.disertatie.template.domain.InfrastructureTemplate;
import com.ase.disertatie.template.service.processing.archive.ArchiveProcessor;
import com.ase.disertatie.template.service.processing.dto.concretes.ConfigMapDto;
import com.ase.disertatie.template.service.processing.dto.concretes.InfrastructureDTO;
import com.ase.disertatie.template.service.processing.providers.templates.InfrastructureProvider;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
public class ArchiveResourceTest {

    @MockBean
    private ArchiveProcessor archiveProcessor;


    @MockBean
    private InfrastructureTemplateRepository templateRepository;

    private final static String TEXT = "apiVersion: v1\n" +
            "kind: ConfigMap\n" +
            "metadata:\n" +
            "  name: cfgName\n" +
            "data: cfgData','CONFIGMAP";
    private final static String TEXT_TO_TEST = "apiVersion: v1\n" +
            "kind: ConfigMap\n" +
            "metadata:\n" +
            "  name: ConfigMap\n" +
            "data: TEXT'";

    private final static byte[] bytes = TEXT_TO_TEST.getBytes();



    @Before
    public void setUp(){
        var template = new InfrastructureTemplate();
        template.setContent(TEXT);
        template.setKind(ComponentKind.CONFIGMAP);
        template.setId(1L);
       when(templateRepository.findByKind(any())).thenReturn(template);
       when(archiveProcessor.createFileFromDTO(any())).thenReturn(bytes);

    }



    @Test
    public void testGetAllCoursesForCurrentUser() {
        var infra = new InfrastructureDTO();
        var configmap = new ConfigMapDto("ConfigMap",TEXT);
        infra.setConfigMap(configmap);

       var bytes = archiveProcessor.createFileFromDTO(infra);

        Assertions.assertEquals(bytes,bytes);

    }


}
