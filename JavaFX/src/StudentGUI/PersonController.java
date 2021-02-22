package StudentGUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.text.ParseException;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PersonController {
    private PersonIO personIO = new PersonIO();


    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNaam;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtBirthDate;
    @FXML
    private TextField txtStreet;
    @FXML
    private TextField txtPhone;
    @FXML
    private TextField txtZipCode;
    @FXML
    private TextField txtDepartmentID;

    @FXML
    private TextField txtSearch;
    @FXML
    private TextField txtSearchName;
    @FXML
    private Label lblErrorMessage;
    @FXML
    private Label lblError;



    public void getStudentButtonPressed(javafx.event.ActionEvent actionEvent) {

        try {
            //ResultSet students = personIO.GetStudents();
            SetErrorDisplay(false);
            PersonViewModel student = personIO.getStudentByLastName(txtSearchName.getText());
            personIO.writeToFile(student);
            txtID.setText(String.valueOf(student.getId()));
            txtNaam.setText(student.getName());
            txtFirstName.setText(student.getFirstName());
            txtBirthDate.setText(String.valueOf(student.getBirthDate()));
            txtStreet.setText(student.getStreet());
            txtPhone.setText(student.getPhone());
            txtZipCode.setText(student.getZipCode());
            txtDepartmentID.setText(student.getDepartmentId());
        }
        catch (Exception e)
        {
            SetErrorDisplay(true);
            lblErrorMessage.setText(e.getMessage());
        }

    }

    public void getNextButtonPressed(javafx.event.ActionEvent actionEvent){
        int id = Integer.parseInt(txtID.getText()) + 1;

        try {
            //ResultSet students = personIO.GetStudents();
            SetErrorDisplay(false);
            PersonViewModel student = personIO.GetStudentByID(String.valueOf(id));
            personIO.writeToFile(student);
            txtID.setText(String.valueOf(student.getId()));
            txtNaam.setText(student.getName());
            txtFirstName.setText(student.getFirstName());
            txtBirthDate.setText(String.valueOf(student.getBirthDate()));
            txtStreet.setText(student.getStreet());
            txtPhone.setText(student.getPhone());
            txtZipCode.setText(student.getZipCode());
            txtDepartmentID.setText(student.getDepartmentId());
        }
        catch (Exception e)
        {
            SetErrorDisplay(true);
            lblErrorMessage.setText(e.getMessage());
        }

    }
    public void getPreviousButtonPressed(javafx.event.ActionEvent actionEvent){


        try {
            int id = Integer.parseInt(txtID.getText()) - 1;
            if (id<0){throw new Exception("Already showing first record");}
            //ResultSet students = personIO.GetStudents();
            SetErrorDisplay(false);
            PersonViewModel student = personIO.GetStudentByID(String.valueOf(id));
            personIO.writeToFile(student);
            txtID.setText(String.valueOf(student.getId()));
            txtNaam.setText(student.getName());
            txtFirstName.setText(student.getFirstName());
            txtBirthDate.setText(String.valueOf(student.getBirthDate()));
            txtStreet.setText(student.getStreet());
            txtPhone.setText(student.getPhone());
            txtZipCode.setText(student.getZipCode());
            txtDepartmentID.setText(student.getDepartmentId());
        }
        catch (Exception e)
        {
            SetErrorDisplay(true);
            lblErrorMessage.setText(e.getMessage());
        }

    }

    public void updateButtonPressed(javafx.event.ActionEvent actionEvent) throws ParseException {
        PersonViewModel person = new PersonViewModel();
        try {
            SetErrorDisplay(false);
            person.setId(Integer.parseInt(txtID.getText()));
            person.setFirstName(txtFirstName.getText());
            person.setName(txtNaam.getText());
            person.setBirthDate(txtBirthDate.getText());
            person.setStreet(txtStreet.getText());
            person.setPhone(txtPhone.getText());
            person.setZipCode(txtZipCode.getText());
            person.setDepartmentId(txtDepartmentID.getText());

            personIO.UpdateStudent(person);
        }
        catch (Exception e){
            SetErrorDisplay(true);
            lblErrorMessage.setText(e.getMessage());
        }
    }

    public void searchButtonPressed(ActionEvent actionEvent) throws Exception {
        try {
            SetErrorDisplay(false);
            //ResultSet students = personIO.GetStudents();
            String id = txtSearch.getText();
            PersonViewModel student = personIO.GetStudentByID(String.valueOf(id));
            personIO.writeToFile(student);
            txtID.setText(String.valueOf(student.getId()));
            txtNaam.setText(student.getName());
            txtFirstName.setText(student.getFirstName());
            txtBirthDate.setText(String.valueOf(student.getBirthDate()));
            txtStreet.setText(student.getStreet());
            txtPhone.setText(student.getPhone());
            txtZipCode.setText(student.getZipCode());
            txtDepartmentID.setText(student.getDepartmentId());
        }
        catch (Exception e)
        {
            SetErrorDisplay(true);
            lblErrorMessage.setText(e.getMessage());
            //throw new Exception("The record could not be found");
        }
    }

    private void SetErrorDisplay(Boolean bool) {
        lblError.setVisible(bool);
        lblErrorMessage.setVisible(bool);
    }
}
