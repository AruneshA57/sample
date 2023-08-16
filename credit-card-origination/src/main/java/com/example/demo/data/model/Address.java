package com.example.demo.data.model;


import com.example.demo.dto.NewCustomer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address extends BaseEntity{
    String address;
    String city;
    String state;
    String pinCode;

    public Address(NewCustomer newCustomer){
        setAddress(newCustomer.getAddress());
        setCity(newCustomer.getCity());
        setState(newCustomer.getState());
        setPinCode(newCustomer.getPinCode());
    }

    public Address() {

    }
}
