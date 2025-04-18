module org.main.csc311registrationform {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.main.csc311registrationform to javafx.fxml;
    exports org.main.csc311registrationform;
    exports org.main.csc311registrationform.Contollers;
    opens org.main.csc311registrationform.Contollers to javafx.fxml;
}