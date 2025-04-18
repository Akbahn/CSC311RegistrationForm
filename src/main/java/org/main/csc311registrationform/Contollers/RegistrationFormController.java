package org.main.csc311registrationform.Contollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.main.csc311registrationform.SceneManager;

import java.io.IOException;

public class RegistrationFormController {
    private static final String NAME_REGEX = "^[A-Za-z]{2,25}$";
    private static final String DOB_REGEX = "^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$";
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@farmingdale\\.edu$";
    private static final String ZIP_REGEX = "^\\d{5}$";

    @FXML
    private Button addBtn;

    @FXML
    private TextField dobTxtF;

    @FXML
    private TextField emailTxtF;

    @FXML
    private TextField firstNameTxtF;

    @FXML
    private TextField lastNametxtF;

    @FXML
    private TextField zipcodeTxtF;

    /**
     * Validates a given input string against the provided regular expression.
     *
     * @param input the input string to validate
     * @param regex the regular expression to test the input against
     * @return true if the input matches the regex and is not null, false otherwise
     * @throws NullPointerException if the regex is null
     */
    private boolean isValid(String input, String regex) {
        return input != null && input.matches(regex);
    }

    @FXML
    public void initialize() {
        fieldColorValidation(firstNameTxtF, NAME_REGEX);
        fieldColorValidation(lastNametxtF, NAME_REGEX);
        fieldColorValidation(dobTxtF, DOB_REGEX);
        fieldColorValidation(emailTxtF, EMAIL_REGEX);
        fieldColorValidation(zipcodeTxtF, ZIP_REGEX);

        addBtn.setDisable(true);
    }

    private void fieldColorValidation(TextField field, String regex) {
        field.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) { 
                boolean valid = isValid(field.getText(), regex);
                field.setStyle(valid ? "-fx-border-color: green;" : "-fx-border-color: red;");
            }
            validateForm();
        });
    }

    private void validateForm() {
        boolean allValid = isValid(firstNameTxtF.getText(), NAME_REGEX)
                && isValid(lastNametxtF.getText(), NAME_REGEX)
                && isValid(dobTxtF.getText(), DOB_REGEX)
                && isValid(emailTxtF.getText(), EMAIL_REGEX)
                && isValid(zipcodeTxtF.getText(), ZIP_REGEX);

        addBtn.setDisable(!allValid);
    }


    @FXML
    private void handleAddButton() {
        boolean allValid = isValid(firstNameTxtF.getText(), NAME_REGEX) &&
                isValid(lastNametxtF.getText(), NAME_REGEX) &&
                isValid(dobTxtF.getText(), DOB_REGEX) &&
                isValid(emailTxtF.getText(), EMAIL_REGEX) &&
                isValid(zipcodeTxtF.getText(), ZIP_REGEX);

        if (allValid) {
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("User Successfully Created");
            successAlert.showAndWait();

            try {
                // Switch scenes and get the controller
                Stage currentStage = (Stage) addBtn.getScene().getWindow();
                UserPageController userController = (UserPageController)
                        SceneManager.switchScene(currentStage, "user-page.fxml");

                // Pass the data
                userController.setUserData(
                        firstNameTxtF.getText(),
                        lastNametxtF.getText(),
                        dobTxtF.getText(),
                        emailTxtF.getText(),
                        zipcodeTxtF.getText()
                );

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Alert errorAlert = new Alert(Alert.AlertType.WARNING);
            errorAlert.setTitle("Invalid Input");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please fill out all fields correctly.");
            errorAlert.showAndWait();
        }
    }




}
