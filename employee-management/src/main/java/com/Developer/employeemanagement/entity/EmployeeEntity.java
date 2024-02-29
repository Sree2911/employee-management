package com.Developer.employeemanagement.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="mt_employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Emp_Id")
    private Long id;

    @Column(name ="Emp_Name")
    private String name;

    @Column(name ="Emp_Gender")
    private String gender;

    @Column(name ="Emp_DateOfBirth")
    private Date dateOfBirth;

    @Column(name="Emp_Address")
    private String address;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String name, String gender, Date dateOfBirth, String address) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
