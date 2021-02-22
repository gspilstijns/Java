package StudentGUI;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PersonViewModel {
    private int Id;
    private String Name;
    private String FirstName;
    private String MiddleName;
    private String BirthDate;
    private String Street;
    private String Phone;
    private String ZipCode;
    private String DepartmentId;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getBirthDate() {

    return BirthDate;


    }
    public String getBirthDateString(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(BirthDate);
        return strDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getZipCode() {
        return ZipCode;
    }

    public void setZipCode(String zipCode) {
        ZipCode = zipCode;
    }

    public String getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(String departmentId) {
        DepartmentId = departmentId;
    }

    public PersonViewModel() {
        Id = 0;
        Name = "Default";
    }

    @Override
    public String toString() {
        return "PersonViewModel{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", BirthDate='" + BirthDate + '\'' +
                ", Street='" + Street + '\'' +
                ", Phone='" + Phone + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                ", DepartmentId='" + DepartmentId + '\'' +
                '}';
    }
}
