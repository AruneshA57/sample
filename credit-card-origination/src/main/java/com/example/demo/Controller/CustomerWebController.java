package com.example.demo.Controller;

import com.example.demo.Service.AmazonS3Service;
import com.example.demo.Service.ApplicationService;
import com.example.demo.Service.CustomerService;
import com.example.demo.data.model.Applications;
import com.example.demo.data.model.Customer;
import com.example.demo.dto.NewCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Customer")
public class CustomerWebController {

    private final CustomerService customerService;
    private final AmazonS3Service amazonS3Service;
    private final ApplicationService applicationService;
    @Autowired
    public CustomerWebController(CustomerService customerService,
                                 AmazonS3Service amazonS3Service,
                                 ApplicationService applicationService) {
        this.customerService = customerService;
        this.amazonS3Service = amazonS3Service;
        this.applicationService = applicationService;
    }

    @PostMapping("/newCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody NewCustomer newCustomer){
        Customer customer = customerService.createNewCustomer(newCustomer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<Customer> getCustomer(Long cusId){
        Customer customer = customerService.getCustomer(cusId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @PostMapping("/new/application")
    public ResponseEntity<Applications> createApplication(
            @RequestPart(value = "aadhar") MultipartFile aadhar,
            @RequestPart(value = "pan") MultipartFile pan,
            @RequestPart(value = "incomeProof") MultipartFile incomeProof,
            @RequestParam(value = "customerId")String customerId,
            @RequestParam(value = "cardType")String cardType) throws Exception {

        Applications applications = applicationService.createApplication(customerId,cardType);
        amazonS3Service.uploadDocuments(aadhar, applications.getAadharFileName());
        amazonS3Service.uploadDocuments(pan, applications.getPanFileName());
        amazonS3Service.uploadDocuments(incomeProof, applications.getIncomeProofFileName());
        return new ResponseEntity<>(applications, HttpStatus.CREATED);
    }

}
