package org.main.csc311registrationform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Utility class for managing scene transitions.
 */
public class SceneManager {

    /**
     * Loads and sets a new scene using the specified FXML file.
     *
     * @param stage    the current JavaFX stage
     * @param fxmlName the name of the FXML file to load (e.g., "confirmation.fxml")
     * @return the controller associated with the loaded FXML file
     * @throws IOException if the FXML file cannot be loaded
     */
    public static Object switchScene(Stage stage, String fxmlName) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneManager.class.getResource(fxmlName));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        return loader.getController();
    }
}
