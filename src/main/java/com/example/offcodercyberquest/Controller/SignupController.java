package com.example.offcodercyberquest.Controller;


import com.example.offcodercyberquest.HelloApplication;
import com.example.offcodercyberquest.UserAuth;
import com.example.offcodercyberquest.UserStats;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
/*
*
*
* making a newUser in singleton type so that it is safe and accessable all over the project and automate stuff
*
*
* */
public class SignupController {

    @FXML
    private Button button;

    @FXML
    private TextField email;

    @FXML
    private Button login_button;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label wronglogin;

    @FXML
    public void login_call(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        wronglogin.setText("Success!");
        m.changeScene("Login.fxml");
    }

    @FXML
    public void switchToLogin(ActionEvent event) throws IOException, InterruptedException {
        if(username.getText().isEmpty() && password.getText().isEmpty() && email.getText().isEmpty()) {
            wronglogin.setText("Please enter your data.");
        }
        else
        {
            String user_name = username.getText();
            String user_password = password.getText();
            String user_email = email.getText();
            UserAuth newUser = new UserAuth();
            int status = newUser.makeUser(user_name,user_password,user_email);
            if(status == -1){
                wronglogin.setText("Please enter correct Username or Email");
            }
            else
            {
                //CALCULATING MAKECHART AT SIGNUP TIME TO REDUCE WAITING TIME LATER
                UserStats stats = new UserStats();
                stats.makeChart(user_name);

                //CHANGING SCENE
                checksignup();
            }
        }
    }

    public void checksignup() throws IOException
    {
        HelloApplication m = new HelloApplication();
        wronglogin.setText("Success!");
        m.changeScene("Dashboard.fxml");
    }

}

