package com.example.kozintek;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainController {

    @FXML
    private Button LoginButton ;
    @FXML
    private Button SigninButton;
    @FXML
    private Button ResetPasswordButton;
    @FXML
    private TextField EmailTextField;
    @FXML
    private TextField PasswordTextField;
    @FXML
    private Label EmailErrorMsg;
    @FXML
    private Label PasswordErrorMsg;
    @FXML
    private Label BlankEmailMsg;
    @FXML
    private Label BlankPasswordMsg;
    @FXML
    private Label BonjourLabel;


    public void setLoginButtonOnAction(ActionEvent e) {
        //EmailErrorMsg.setText("Invalid Email");
        //PasswordErrorMsg.setText("Wrong Password");
        //EmailTextField.setStyle("-fx-border-color: #ff5a5a; -fx-border-radius: 6; -fx-background-color:white; -fx-font-family : \"Poppins\" ;-fx-font-size : 15px ; -fx-border-width: 2");

        if ( EmailTextField.getText().isBlank() == true ) {
            BlankEmailMsg.setText("Please enter your Email");
            EmailTextField.setStyle("-fx-border-color: #FF8914; -fx-border-radius: 6; -fx-background-color:white; -fx-font-family : \"Poppins\" ;-fx-font-size : 15px ; -fx-border-width: 2");
        }else{
            BlankEmailMsg.setText("");
            EmailTextField.setStyle("-fx-background-color:white; -fx-font-family : \"Poppins\" ;-fx-font-size : 15px ; -fx-border-width: 2");
        }if ( PasswordTextField.getText().isBlank() == true ) {
            BlankPasswordMsg.setText("Please enter your Password");
            PasswordTextField.setStyle("-fx-border-color: #FF8914; -fx-border-radius: 6; -fx-background-color:white; -fx-font-family : \"Poppins\" ;-fx-font-size : 15px ; -fx-border-width: 2");
        }else{
            BlankPasswordMsg.setText("");
            PasswordTextField.setStyle("-fx-background-color:white; -fx-font-family : \"Poppins\" ;-fx-font-size : 15px ; -fx-border-width: 2");
        }if ( EmailTextField.getText() == "bruh" && PasswordTextField.getText() == "bruh" ){
            BlankPasswordMsg.setText("IXILO");
        }

        if ( EmailTextField.getText().isBlank() == false && PasswordTextField.getText().isBlank() == false ) {
            validateLogin();
        }

    }

    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String LoginVerifyQuery = "SELECT count(1) FROM UserAccounts WHERE Email = '" + EmailTextField.getText() + "' AND Password = '" + PasswordTextField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(LoginVerifyQuery);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1 ){
                    BonjourLabel.setText("Bonjour hhhhh");
                }else {
                    BlankEmailMsg.setText("Ser a3mo ser");
                    BlankEmailMsg.setText("Invalid Login");
                    EmailTextField.setStyle("-fx-border-color: #ff5a5a; -fx-border-radius: 6; -fx-background-color:white; -fx-font-family : \"Poppins\" ;-fx-font-size : 15px ; -fx-border-width: 2");
                    PasswordTextField.setStyle("-fx-border-color: #ff5a5a; -fx-border-radius: 6; -fx-background-color:white; -fx-font-family : \"Poppins\" ;-fx-font-size : 15px ; -fx-border-width: 2");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
