package com.offcn.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileUpLoad {
    @RequestMapping("/upload")
    public String FileUpLoad(MultipartFile file){
        try {
            File path =  new File("D:\\upload");
            String filename = file.getOriginalFilename();
            String finalname = UUID.randomUUID().toString().replace("-","")+filename;
            File file2 = new File(path,finalname);
            file.transferTo(file2);
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download() throws Exception{
        String path = "D:\\upload";
        String fileName = "中文.txt";
        byte[] bytes = FileUtils.readFileToByteArray(new File(path,fileName));
        HttpHeaders handler = new HttpHeaders();
        String newFileName = new String(fileName.getBytes(),"iso-8859-1");
        handler.setContentDispositionFormData("attachment",newFileName);
        handler.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes,handler, HttpStatus.OK);
        return responseEntity;
    }
}
