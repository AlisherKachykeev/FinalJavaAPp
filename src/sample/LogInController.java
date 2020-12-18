package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    @FXML
    private Button signupBtn;

    @FXML
    private Button closeBtn;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button enterBtn;

    @FXML
    private Button startTestBtn;

    @FXML
    public void onMouseClickedcloseBtn(MouseEvent mouseEvent) {
        final Node source = (Node) mouseEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        enterBtn.setOnAction(event -> {
            String loginText = usernameField.getText().trim();
            String loginPassword = passField.getText().trim();
            if (!loginText.equals("") && !loginPassword.equals("")) {
                enterBtn(loginText, loginPassword);
            } else {
                System.out.println("Error");
            }
        });
        startTestBtn.setOnAction(event -> {
            startTestBtn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/TestSample.fxml"));
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
        signupBtn.setOnAction(event -> {
            signupBtn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/SignUpSample.fxml"));
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

    private void enterBtn(String loginText, String loginPassword) {
    }
}

