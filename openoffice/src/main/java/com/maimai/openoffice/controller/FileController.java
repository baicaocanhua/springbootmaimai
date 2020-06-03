package com.maimai.openoffice.controller;

import com.artofsolving.jodconverter.*;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;
import com.itextpdf.text.DocumentException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-05-25 14:33
 **/
@RestController
public class FileController {
    @RequestMapping(value = "importFile", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String importFile(@RequestPart("file") MultipartFile file, @RequestPart("openorstream") String openorstream) throws IOException {


        String aa = getExtensionName(file.getOriginalFilename());
        System.out.println(aa);
        String originalPath = "D:/222/" + file.getOriginalFilename();
        String targetPath = "D:/222/123.html";
//        String originalPath = "/222/abc.doc";
//        String targetPath = "/222/123.html";
        File sourceFile = new File(originalPath);
        file.transferTo(sourceFile);
        File targetFile = new File(targetPath);
        OpenOfficeConnection connection = null;
        try {
            //49.235.232.253
            connection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
            connection.connect();
            DocumentConverter convert;
            if ("1".equals(openorstream)) {
                //convert = new StreamOpenOfficeDocumentConverter(connection);
                convert = new ConverterDocument(connection);

            } else {
                convert = new OpenOfficeDocumentConverter(connection);
            }

            DocumentFormatRegistry factory = new BasicDocumentFormatRegistry();
            DocumentFormat outputDocumentFormat = factory.getFormatByFileExtension("html");
//            convert.convert(sourceFile, targetFile, outputDocumentFormat);
            convert.convert(sourceFile, targetFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "";
    }


    public static String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }


    public static void main(String[] args) throws IOException, DocumentException {
        //Java - poi和itext将Excel转化为PDF（支持图片）
        //https://blog.csdn.net/y_j_zhang/article/details/102494384
//        String xls = "D:/111/4444323.xls";
//        String pdf = "D:/222/123.pdf";
//        Xls2Pdf xls2Pdf = new Xls2Pdf(xls, 0);
//        xls2Pdf.savePdf(pdf);


        String strTemplate = "{\"k2\": %d, \"k1\": \"1111qwertyuiopasdfghjklzxcvbnm\"}";
        int time = 10000000;


        System.out.println(String.format(strTemplate, 333));

        String aa="asda%sasdad%s2323asdad%s";
        System.out.println(String.format(aa, "333","maimai","444"));

        String str=null;
        str=String.format("Hi,%s", "王力");
        System.out.println(str);

    }
}
