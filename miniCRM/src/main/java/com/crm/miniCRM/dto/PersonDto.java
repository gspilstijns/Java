package com.crm.miniCRM.dto;



import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonDto {

    private Long id;


    private String firstName;
    private String lastName;
    private String birthDay;

    private List <AddressDto> addressDtoList;
    private List <CommunityDto> communityDtolist;


    private Boolean archived;

    public Boolean getArchived () {
        return archived;
    }

    public void setArchived ( Boolean archived ) {
        this.archived = archived;
    }

    public PersonDto() {
    }

    public List < AddressDto > getAddressDtoList () {
        return addressDtoList;
    }

    public void setAddressDtoList ( List < AddressDto > addressDtoList ) {
        this.addressDtoList = addressDtoList;
    }

    public List < CommunityDto > getCommunityDtolist () {
        return communityDtolist;
    }

    public void setCommunityDtolist ( List < CommunityDto > communityDtolist ) {
        this.communityDtolist = communityDtolist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public PersonDto(Long id, String firstName, String lastName, String birthDay) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.archived = false;

    }

    public PersonDto ( Long id , String firstName , String lastName , String birthDay , List < AddressDto > addressDtoList , List < CommunityDto > communityDtolist ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.addressDtoList = addressDtoList;
        this.communityDtolist = communityDtolist;
        this.archived = false;
    }
}
