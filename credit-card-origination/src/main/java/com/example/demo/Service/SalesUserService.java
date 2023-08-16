package com.example.demo.Service;

import com.example.demo.Repository.SalesUserRepository;
import com.example.demo.data.enums.SalesUserGrade;
import com.example.demo.data.model.SalesUser;
import com.example.demo.dto.NewSalesUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalesUserService {

//    private final SalesUserRepository salesUserRepository;
//    @Autowired
//    public SalesUserService(SalesUserRepository salesUserRepository) {
//        this.salesUserRepository = salesUserRepository;
//    }
//
//    public SalesUser createSalesUser(NewSalesUser newSalesUser){
//        SalesUser user = new SalesUser();
//        user.setGrade(SalesUserGrade.getValue(newSalesUser.getRole()));
//        user.setName(newSalesUser.getName());
//        user.setEmployeeId("EMP000" + newSalesUser.toString());
//    }
}

