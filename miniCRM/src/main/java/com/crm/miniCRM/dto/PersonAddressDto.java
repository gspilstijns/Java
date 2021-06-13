package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.persistence.PersonAddressID;

public class PersonAddressDto {
    private PersonAddressID Id;

    private String email;
    private String phone;
    private String mobile;
    private String type;
    private AddressDto addressDto;


    public PersonAddressDto () {
    }

    public PersonAddressDto ( PersonAddressID id , String email , String phone , String mobile , String type ) {
        Id = id;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.type = type;
    }

    public PersonAddressDto ( PersonAddressID id , String email , String phone , String mobile , String type , AddressDto addressDto ) {
        Id = id;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.type = type;
        this.addressDto = addressDto;
    }

    public AddressDto getAddressDto () {
        return addressDto;
    }

    public void setAddressDto ( AddressDto addressDto ) {
        this.addressDto = addressDto;
    }

    public PersonAddressID getId () {
        return Id;
    }

    public void setId ( PersonAddressID id ) {
        Id = id;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone ( String phone ) {
        this.phone = phone;
    }

    public String getMobile () {
        return mobile;
    }

    public void setMobile ( String mobile ) {
        this.mobile = mobile;
    }

    public String getType () {
        return type;
    }

    public void setType ( String type ) {
        this.type = type;
    }
}
