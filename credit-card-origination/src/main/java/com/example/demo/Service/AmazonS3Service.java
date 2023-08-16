package com.example.demo.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.demo.data.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class AmazonS3Service {
    private final AmazonS3 s3client;

    @Autowired
    public AmazonS3Service(AmazonS3 s3client) {
        this.s3client = s3client;
    }

    @Value("${aws.s3.bucket.name}")
    private String bucketName;

    public void uploadDocuments(MultipartFile file, String fileName) throws Exception {
        log.info("Uploading new {} -> {}", fileName);
        uploadFile(fileName,file);
    }


    public void uploadFile(String fileName, MultipartFile multipartFile) throws Exception {
        try {
            File file = convertMultiPartToFile(multipartFile);
            log.info("Uploading file...");
            uploadFileTos3bucket(fileName, file);
            log.info("Upload successful");
            file.delete();
        } catch (Exception e) {
            log.error("Upload unsuccessful: {}",e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    private void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName, fileName, file)
                .withCannedAcl(CannedAccessControlList.Private));
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }




}
