package com.crm.miniCRM.dto;

import com.opencsv.bean.CsvBindByName;

public class PersonImportDto {
    @CsvBindByName(column = "firstname")
    private String firstName;
    @CsvBindByName(column = "lastname")
    private String lastName;
    @CsvBindByName(column = "birthday")
    private String birthDay;

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    public String getBirthDay () {
        return birthDay;
    }

    public void setBirthDay ( String birthDay ) {
        this.birthDay = birthDay;
    }
}
