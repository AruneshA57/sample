package com.example.demo.Service;

import com.example.demo.Repository.ApplicationRepository;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.data.enums.ApplicationStatus;
import com.example.demo.data.model.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository,
                              CustomerRepository customerRepository) {
        this.applicationRepository = applicationRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Applications createApplication(String id, String cardType){
        Applications applications = new Applications();
        applications.setDateCreated("rgggtg");
        applications.setApplicationStatus(ApplicationStatus.CreditScoreFetchPending);
        applications.setCreditCardType(cardType);

        applications = applicationRepository.save(applications);
        applications.setApplicationId("APPN000"+applications.getId().toString());
        applications.setCustomer(customerRepository.getCustomerById(Long.valueOf(id)));
        applications.setAadharFileName(applications.getCustomer().getCustomerName()+"_"+applications.getCustomer().getId()+"_aadhar");
        applications.setPanFileName(applications.getCustomer().getCustomerName()+"_"+applications.getCustomer().getId()+"_pan");
        applications.setIncomeProofFileName(applications.getCustomer().getCustomerName()+"_"+applications.getCustomer().getId()+"_income_proof");
        return applicationRepository.save(applications);
    }


}
