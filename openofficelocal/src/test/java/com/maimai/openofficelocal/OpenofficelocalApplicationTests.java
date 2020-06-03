package com.maimai.openofficelocal;

import org.jodconverter.DocumentConverter;
import org.jodconverter.office.OfficeException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
class OpenofficelocalApplicationTests {

    @Autowired
    private DocumentConverter converter;

    @Test
    void contextLoads() throws OfficeException {
        File inputFile = new File("D:/111/111.docx");


        File outputFile = new File("D:/222/123.html");
        converter.convert(inputFile).to(outputFile).execute();
    }

}
