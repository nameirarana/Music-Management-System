package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class CreateAccountController implements Initializable {

    @FXML
    private ImageView logoImageView ;
    @FXML
    private TextField FullNameTextField ; //full name
    @FXML
    private TextField emailAddressTextField ; //email
    @FXML
    private TextField userNameTextField ; //username
    @FXML
    private PasswordField passwordField ; //password
    @FXML
    private PasswordField con_passwordField ; //confirm password
    @FXML
    private TextField creditCardTextField ; // credit card number
    @FXML
    private TextField pinTextField ; // credit card pin
    @FXML
    private DatePicker dob; //date
    @FXML
    private RadioButton male ; //male
    @FXML
    private RadioButton female ; //female
    @FXML
    private Label invalidLabel ; //form not properly filled
    @FXML
    private Label passwordLabel ; //password condition does not matches
    @FXML
    private Label con_passwordLabel ; //password does not match
    @FXML
    private CheckBox termsCheckBox ; //terms not filled
    @FXML
    private Label invalidemailid ; //email id conditions not fulfilled
    @FXML
    private Label invalidusername ; //username conditions not fulfilled
    @FXML
    private Label pinlabel; ; //pin error

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Logo Image
        File logoimageFile=new File("logo-white.png") ;
        Image logoImage=new Image(logoimageFile.toURI().toString()) ;
        logoImageView.setImage(logoImage) ;

        //Creating Toggle
        ToggleGroup gender=new ToggleGroup() ;
        male.setToggleGroup(gender);
        female.setToggleGroup(gender);

    }

    public void signUpButtonClicked() throws ParseException {

        invalidLabel.setText("\0");
        passwordLabel.setText("\0") ; //password condition does not matches
        con_passwordLabel.setText("\0") ; //password does not match
        invalidemailid.setText("\0") ; //email id conditions not fulfilled
        invalidusername.setText("\0") ; //username conditions not fulfilled
        pinlabel.setText("\0");  //pin error

        //Account Created
        System.out.println("Sign Up");

        System.out.println(termsCheckBox.isSelected());

        String temp = emailAddressTextField.getText();

        int temp_username = 0;
        int temp_email = 0;

        String username = userNameTextField.getText();
        String email = emailAddressTextField.getText();

        Music_System music = new Music_System();

        temp_username = music.check_username_availability(username); //checking if username available or not
        temp_email = music.check_email_availability(email); //checking if username available or not

        int count = 0; //check

        if(emailAddressTextField.getText().isBlank() || passwordField.getText().isBlank() || con_passwordField.getText().isBlank() ||
                userNameTextField.getText().isBlank() || creditCardTextField.getText().isBlank() || pinTextField.getText().isBlank() ||
                FullNameTextField.getText().isBlank() || dob.getValue()==null)
        {
            con_passwordField.setText("\0");
            System.out.println("Empty");
            invalidLabel.setText("Please fill all slots");
            count = 1;
        }
        else if (!temp.contains("@"))
        {
            con_passwordField.setText("\0");
            emailAddressTextField.setText("\0");
            invalidemailid.setText("Invalid Email ID");
            temp_email = 0;
            count = 1;
        }
        else if  ((temp_email == 0) && (emailAddressTextField.getText() !=null))
        {
            con_passwordField.setText("\0");
            emailAddressTextField.setText("\0");
            invalidemailid.setText("Email is not available");
            count = 1;
        }
        else if  (temp_username == 0)
        {
            con_passwordField.setText("\0");
            userNameTextField.setText("\0");
            invalidusername.setText("Username is not available");
            count = 1;
        }
        else if(passwordField.getText().length()<8)
        {
            passwordField.setText("\0");
            con_passwordField.setText("\0");
            invalidLabel.setText("\0");
            passwordLabel.setText("Must have at least 8 characters");
            count = 1;
        }
        else if(!passwordField.getText().equals(con_passwordField.getText()))
        {
            invalidLabel.setText("\0");
            if(passwordField.getText().length()>=8)
            {
                passwordLabel.setText("\0");
                con_passwordField.setText("\0");
                passwordField.setText("\0");
            }
            con_passwordLabel.setText("Password doesn't match!!");
            count = 1;
        }
        else if(!male.isSelected() && !female.isSelected())
        {
            con_passwordField.setText("\0");
            invalidLabel.setText("Please fill all slots");
            count = 1;
        }

        else if(!termsCheckBox.isSelected())
        {
            con_passwordField.setText("\0");
            invalidLabel.setText("Kindly check the box");
            count = 1;
        }

        else if (dob.getValue()==null)
        {
            con_passwordField.setText("\0");
            invalidLabel.setText("Kindly enter dob");
            count = 1;
        }

        String gender = "";
        if(male.isSelected())
        {
            gender = "male";
        }
        else if (female.isSelected())
        {
            gender = "female";
        }

        CreditCard credentials = new CreditCard(); //for credit card details

        int number = Integer.parseInt(creditCardTextField.getText());
        int pin = Integer.parseInt(pinTextField.getText());
        credentials.setCard_Number(number);
        credentials.setPIN(pin);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

        String str = ft.format(ft.parse(this.dob.getValue().toString()));

        Date date = null;

        try {
            date = sdf.parse(str);

            sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("Date: " + sdf.format(date));
        } catch (ParseException e) {
            System.out.println("Parse Exception");
        }

        if ((temp_username != 0) && (temp_email != 0) && (count==0)) {
            int temp_2 = music.Create_User_Account(FullNameTextField.getText(), userNameTextField.getText(), date, gender, credentials, emailAddressTextField.getText(), passwordField.getText()); //creating user account

            if (temp_2 == 1) {
                System.out.print("Account Created !\n");
            } else {
                System.out.print("ERROR ! Account not Created !\n");
                System.out.print("Entered pin is incorrect !\n");
                if (count == 0)
                {
                    pinlabel.setText("Invalid PIN");
                }
            }
        }

    }

}
