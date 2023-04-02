package com.example.helpdesksoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller extends Application {


    @FXML
    private Button exitButton;
    @FXML
    private Label loginMessageLevel;

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent e) {


        if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
            userValidationLogin();


        } else {
            loginMessageLevel.setText("Error! Please enter username and password!");
        }
    }

    public void exitButtonOnAction(ActionEvent e) {

        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();

    }


    public void mainPage() {
        try {


            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 511);
            Stage mainPAge = new Stage();
            mainPAge.initStyle(StageStyle.UTILITY);
            mainPAge.setTitle(" Help Desk Software-admin");
            mainPAge.setScene(scene);
            mainPAge.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }

    }

    public void userPage() {
        try {


            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("userPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 511);
            Stage mainPAge = new Stage();
            mainPAge.initStyle(StageStyle.UTILITY);
            mainPAge.setTitle("Help Desk Software-user");
            mainPAge.setScene(scene);
            mainPAge.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }


    }

    public void userValidationLogin() {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnetction();

        String verifyLogin = "SELECT count(1) FROM users WHERE user_name ='" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    mainPage();
                } else {
                    loginMessageLevel.setText("Incorrect login or password! Please, try login or password!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}

