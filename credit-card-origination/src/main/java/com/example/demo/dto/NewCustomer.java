package com.example.demo.dto;


import com.example.demo.data.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCustomer {

    String name;
    String email;
    String phone;
    String dateOfBirth;
    String aadharNo;
    String panNumber;
    String AnnualIncome;
    String address;
    String city;
    String state;
    String pinCode;



    @Override
    public String toString() {
        return "NewCustomer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", aadharNo='" + aadharNo + '\'' +
                ", panNumber='" + panNumber + '\'' +
                ", AnnualIncome='" + AnnualIncome + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}
