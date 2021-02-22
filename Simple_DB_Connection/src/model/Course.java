package model;

public class Course {
    private String courseID;
    private String subjectID;
    private int courseNumber;
    private String title;
    private int numOfCredits;

    public Course(String courseID, String subjectID, int courseNumber, String title, int numOfCredits) {
        this.courseID = courseID;
        this.subjectID = subjectID;
        this.courseNumber = courseNumber;
        this.title = title;
        this.numOfCredits = numOfCredits;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfCredits() {
        return numOfCredits;
    }

    public void setNumOfCredits(int numOfCredits) {
        this.numOfCredits = numOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", subjectID='" + subjectID + '\'' +
                ", courseNumber=" + courseNumber +
                ", title='" + title + '\'' +
                ", numOfCredits=" + numOfCredits +
                '}';
    }
}
