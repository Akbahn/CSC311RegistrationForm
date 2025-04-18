package org.main.csc311registrationform.Contollers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UserPageController {

    @FXML
    private TextField dobTxtF;

    @FXML
    private TextField emailTxtF;

    @FXML
    private TextField firstNameTxtF;

    @FXML
    private TextField lastNameTxtF;

    @FXML
    private TextField zipcodeTxtF;

    @FXML
    private Button editBtn;

    @FXML
    private Button saveBtn;

    /**
     * Fills in the user data into the corresponding text fields.
     */
    public void setUserData(String firstName, String lastName, String dob, String email, String zipcode) {
        firstNameTxtF.setText(firstName);
        lastNameTxtF.setText(lastName);
        dobTxtF.setText(dob);
        emailTxtF.setText(email);
        zipcodeTxtF.setText(zipcode);
    }

    @FXML
    void enableEdit(ActionEvent event) {
        firstNameTxtF.setEditable(true);
        lastNameTxtF.setEditable(true);
        dobTxtF.setEditable(true);
        emailTxtF.setEditable(true);
        zipcodeTxtF.setEditable(true);
    }

    @FXML
    void saveAll(ActionEvent event) {
        firstNameTxtF.setEditable(false);
        lastNameTxtF.setEditable(false);
        dobTxtF.setEditable(false);
        emailTxtF.setEditable(false);
        zipcodeTxtF.setEditable(false);
    }

}
