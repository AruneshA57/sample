package com.example.demo.data.model;

import com.example.demo.data.enums.SalesUserGrade;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class SalesUser extends BaseEntity {

    String employeeId;
    String password;
    String name;
    SalesUserGrade grade;
    @OneToMany
    Set<Applications> applicationsSet;

}
