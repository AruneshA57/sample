package com.example.demo.data.model;

import com.example.demo.dto.NewCustomer;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Customer extends BaseEntity {


     String CustomerId;
     String customerName;
     String email;
     String phone;


     @OneToOne
     Address address;


     Boolean isManhattanAvailable;
     Boolean isPetrolAvailable;
     Boolean isTravelAvailable;

     @OneToMany
     private Set<Applications> applicationsSet;
     Integer creditScore;

     public Customer(NewCustomer newCustomer){
          setCustomerName(newCustomer.getName());
          setEmail(newCustomer.getEmail());
          setPhone(newCustomer.getPhone());
          setCreditScore(0);
     }






}
