package model;

import java.util.Date;

public class Student {
    private String ssn;
    private String firstName;
    private String mi;
    private String lastName;
    private Date birthDate;
    private String street;
    private String phone;
    private int zipCode;
    private String deptID;

    public Student(String ssn, String firstName, String mi, String lastName, Date birthDate, String street, String phone, int zipCode, String deptID) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.mi = mi;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.street = street;
        this.phone = phone;
        this.zipCode = zipCode;
        this.deptID = deptID;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getDeptID() {
        return deptID;
    }

    public void setDeptID(String deptID) {
        this.deptID = deptID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", mi='" + mi + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", street='" + street + '\'' +
                ", phone='" + phone + '\'' +
                ", zipCode=" + zipCode +
                ", deptID='" + deptID + '\'' +
                '}';
    }
}

