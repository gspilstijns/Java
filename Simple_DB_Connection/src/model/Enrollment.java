package model;

import javax.print.DocFlavor;
import java.time.LocalDate;

public class Enrollment {
    private String ssn;
    private String courseID;
    private LocalDate dateRegistered;
    private String grade;

    public Enrollment(String ssn, String courseID, LocalDate dateRegistered, String grade) {
        this.ssn = ssn;
        this.courseID = courseID;
        this.dateRegistered = dateRegistered;
        this.grade = grade;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDate dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "ssn='" + ssn + '\'' +
                ", courseID='" + courseID + '\'' +
                ", dateRegistered=" + dateRegistered +
                ", grade='" + grade + '\'' +
                '}';
    }
}
