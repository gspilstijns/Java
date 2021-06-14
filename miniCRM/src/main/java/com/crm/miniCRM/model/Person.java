package com.crm.miniCRM.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="person")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "person_address",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "ID")
    )
    private List<Address> person_address;



    @ManyToMany
    @JoinTable(
            name = "member",
            joinColumns = @JoinColumn(name = "COMMUNITY_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID"))
    private List<Community> member;


    private String firstName;
    private String lastName;
    private LocalDate birthDay;

    private Boolean archived;

    public Boolean getArchived () {
        return archived;
    }

    public void setArchived ( Boolean archived ) {
        this.archived = archived;
    }

    public Person() {
    }

    public Person ( String firstName , String lastName , LocalDate birthDay , Boolean archived ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.archived = archived;
    }

    public Person( String firstName, String lastName, LocalDate birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%d, firstName='%s', lastName='%s', birthDay= '%S']",
                id, firstName, lastName, birthDay.toString());
    }

    public List < Address > getPerson_address () {
        return person_address;
    }

    public void setPerson_address ( List < Address > person_address ) {
        this.person_address = person_address;
    }

    public List < Community > getMember () {
        return member;
    }

    public void setMember ( List < Community > member ) {
        this.member = member;
    }

    public void setId( Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
}