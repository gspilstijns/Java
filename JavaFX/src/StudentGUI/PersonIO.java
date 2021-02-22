package StudentGUI;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PersonIO {
    public List<PersonViewModel> GetAllStudents() throws ClassNotFoundException, SQLException {
        Connection connection = CreateConnection();

        // Create a statement
        Statement statement = connection.createStatement();

        // Execute a statement

        ResultSet resultSet = statement.executeQuery
                ("select * from Student");


        List<PersonViewModel> personList = new ArrayList<>();
        // Iterate through the result and print the student names
        while (resultSet.next()) {

            PersonViewModel person = new PersonViewModel();

            person.setId(resultSet.getInt(1));
            person.setFirstName(resultSet.getString(2));
            person.setName(resultSet.getString(4));
            person.setMiddleName(resultSet.getString(3));
            person.setPhone(resultSet.getString(7));
            person.setBirthDate(resultSet.getString(5));
            person.setStreet(resultSet.getString(6));
            person.setZipCode(resultSet.getString(8));
            person.setDepartmentId(resultSet.getString(9));

            personList.add(person);
        }
        // Close the connection
        connection.close();

        return personList;



    }

    public void UpdateStudent(PersonViewModel person) throws SQLException, ClassNotFoundException {
        Connection connection = CreateConnection();
        Statement statement = connection.createStatement();

        //Date date = person.getBirthDate();
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        //String strDate = dateFormat.format(date);

        String queryString = "UPDATE Student SET firstName='"+person.getFirstName() + "', mi='" +
                person.getMiddleName() + "', lastname='" + person.getName() + "', birthDate='" +
                person.getBirthDate() + "', street='" + person.getStreet() + "', phone='" +
                person.getPhone() + "', zipCode='" + person.getZipCode() + "', deptId='" +
                person.getDepartmentId() + "'" + " WHERE ssn='"+ person.getId() +"'" ;

        statement.executeUpdate(queryString);

    }
    public PersonViewModel getStudentByLastName(String name) throws Exception {
        Connection connection = CreateConnection();
        // Create a statement
        Statement statement = connection.createStatement();

        // Execute a statement
        String queryString = "select * from Student " +
                "where Student.lastname = '" + name + "'";

        ResultSet result = statement.executeQuery(queryString);
        PersonViewModel person = new PersonViewModel();
        while (result.next()){
            // omzetten in een person object
            person.setId(result.getInt(1));
            person.setFirstName(result.getString(2));
            person.setName(result.getString(4));
            person.setMiddleName(result.getString(3));
            person.setPhone(result.getString(7));
            person.setBirthDate(result.getString(5));
            person.setStreet(result.getString(6));
            person.setZipCode(result.getString(8));
            person.setDepartmentId(result.getString(9));
        }
        // Close the connection
        connection.close();
        if (person.getName() == "Default"){throw new Exception("No record found");}
        return person;
    }

    private Connection CreateConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://root:root@localhost/java_course?serverTimezone=CET");

        return connection;
    }
    public void writeToFile(PersonViewModel person){
        File output = new File("resources\\PersonOutputFile.txt");
        String filepath = output.getPath();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filepath,true);
            PrintStream ps = new PrintStream(fileOutputStream);
            ps.println(person.toString());
            ps.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PersonViewModel GetStudentByID(String id) throws Exception {
        Connection connection = CreateConnection();
        // Create a statement
        Statement statement = connection.createStatement();

        // Execute a statement
        String queryString = "select * from Student " +
                "where ssn= '" + id + "'";

        ResultSet result = statement.executeQuery(queryString);
        PersonViewModel person = new PersonViewModel();

        while (result.next()){
            // omzetten in een person object
            person.setId(result.getInt(1));
            person.setFirstName(result.getString(2));
            person.setName(result.getString(4));
            person.setMiddleName(result.getString(3));
            person.setPhone(result.getString(7));
            person.setBirthDate(result.getString(5));
            person.setStreet(result.getString(6));
            person.setZipCode(result.getString(8));
            person.setDepartmentId(result.getString(9));
        }

        // Close the connection
        connection.close();
        if (person.getName() == "Default"){throw new Exception("No record found");}
        return person;
    }
}
