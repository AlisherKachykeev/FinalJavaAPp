package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    @FXML
    private Button loginBtn;

    @FXML
    private Button closeBtn;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button registerBtn;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private TextField countryField;

    @FXML
    private RadioButton maleRadioBtn;

    @FXML
    private RadioButton femaleRadioBtn;

    @FXML
    public void onMouseClickedcloseBtn(MouseEvent mouseEvent) {
        final Node source = (Node) mouseEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        DB_handler dbHandler = new DB_handler();
        registerBtn.setOnAction(event -> {
            dbHandler.signUpUser(nameField.getText(), surnameField.getText(),
                    usernameField.getText(), passField.getText(),countryField.getText(),"Male");
        });
        loginBtn.setOnAction(event -> {
            loginBtn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/LogInSample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.showAndWait();

        });
    }
}

