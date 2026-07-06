package com.staragile.medicure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Doctor {

    @Id
    private Integer doctorRegNo;

    private String doctorName;
    private String specialization;
    private String hospital;
    private Integer experience;
    private String city;
    private String mobileNo;
}
