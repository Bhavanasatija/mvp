package org.ndhb.pycare.registration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.ndhb.pycare.registration.aggregate.RegistrationType;
import org.ndhb.pycare.registration.aggregate.StatusType;

import com.opencsv.bean.CsvBindByName;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    @CsvBindByName
    private UUID id;
    @CsvBindByName
    private String patientLocalId;
    @CsvBindByName
    private String uhid;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String dob;
    @CsvBindByName
    private int age;
    @CsvBindByName
    private StatusType status;
    @CsvBindByName
    private RegistrationType registrationType;



}
