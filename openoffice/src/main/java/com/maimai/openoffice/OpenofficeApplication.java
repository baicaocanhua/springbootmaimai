package com.maimai.openoffice;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
import org.jodconverter.JodConverter;
import org.jodconverter.OfficeDocumentConverter;
import org.jodconverter.office.OfficeManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;

@SpringBootApplication
@RestController
public class OpenofficeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OpenofficeApplication.class, args);
//        try {
////            aa();
////        }catch (Exception e){
////            e.printStackTrace();
////        }

        //JodConverter.convert()
        //OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        //OfficeManager officeManager
    }


    public static void aa() throws IOException {
        File sourceFile = new File("D:/111/111.docx");
        System.out.println();

        File targetFile = new File("D:/111/2020年主体经销协议.html");
        OpenOfficeConnection connection = null;
        try {
            //DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
            connection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
            connection.connect();
            //DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
            converter.convert(sourceFile, targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null && connection.isConnected()) {
                connection.disconnect();
            }
        }

    }


}
