package com.maimai.openoffice;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.net.ConnectException;

@SpringBootApplication
public class OpenofficeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OpenofficeApplication.class, args);
        try {
            aa();
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public static void aa() throws IOException {
        File sourceFile = new File("D:/111/123.docx");
        System.out.println();

        File targetFile = new File("D:/111/2020年主体经销协议.html");
        OpenOfficeConnection connection = null;
        try {
            //DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
            connection = new SocketOpenOfficeConnection("49.235.232.253", 8100);
            connection.connect();
            DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
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
