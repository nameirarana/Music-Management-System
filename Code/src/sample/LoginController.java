package sample;

import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class LoginController implements Initializable {

    @FXML
    private Button signUpButton ;
    @FXML
    private Label create ;
    @FXML
    private Label passLabel ;
    @FXML
    private Label userLabel ;
    @FXML
    private ImageView logoImageView ;
    @FXML
    private ImageView lockImageView ;
    @FXML
    private TextField usernameField ;
    @FXML
    private PasswordField passwordTextField ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Logo Image
        File logoimageFile=new File("logo-white.png") ;
        Image logoImage=new Image(logoimageFile.toURI().toString()) ;
        logoImageView.setImage(logoImage) ;

        //Lock Image
        File lockimageFile=new File("hhj.png") ;
        Image lockImage=new Image(lockimageFile.toURI().toString()) ;
        lockImageView.setImage(lockImage) ;

    }

    public void signInClicked(){

        userLabel.setText("\0");
        passLabel.setText("\0");

        String username = usernameField.getText();
        String password = passwordTextField.getText();
        int temp_username = 0;
        int temp_password = 0;
        Music_System music = new Music_System();
        temp_username = music.check_username_availability(username); //checking if username available or not
        temp_password = music.check_password_correctness(username, password); //checking if username available or not

        if(temp_username != 0) //already does not exits
        {
            usernameField.setText("\0");
            passwordTextField.setText("\0");
            userLabel.setText("Invalid username");
        }
        else if (temp_password != 0) //password does not match username
        {
            passwordTextField.setText("\0");
            passLabel.setText("Invalid password");
        }
        else
        {
            System.out.print("LOGGED IN \n");
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Users u = new Users(usernameField.getText(),passwordTextField.getText());
            UserHolder holder = UserHolder.getInstance();
            // Step 3
            holder.setUser(u);
            Stage window=(Stage)create.getScene().getWindow();
            //window.setUserData(u);
            System.out.println("Print");
            window.setScene(new Scene(root, 1000, 653));
        }

    }

    public void createAccount(){
        //create Account
        System.out.println("Mouse clicked");

        System.out.println("Button 1 clicked");
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //users_temp u = new users_temp(usernameField.getText(),passwordTextField.getText());



        System.out.println("Print");
        Stage window=(Stage)create.getScene().getWindow();
        //window.setUserData(u);
        System.out.println("Print");
        window.setScene(new Scene(root, 1000, 653));
        System.out.println("Print");

        System.out.println("Print");

    }

    public void forgotPassword(){
        //Forgot Password
        System.out.println("Password Forgot");
    }

}

