package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static boolean isSplashLoaded = false;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("MUSIC MANAGEMENT SYSTEM");
        primaryStage.setScene(new Scene(root, 1000,653));
        primaryStage.show();
    }


    public static void main(String[] args) throws IOException, LineUnavailableException, UnsupportedAudioFileException, ParseException
    {
        launch(args);
        /*int choice, choice_temp;

        System.out.print("1: Music Recommender\n");
        System.out.print("2: Plagiarism Checker\n");
        System.out.print("3: Create User Account\n");
        System.out.print("4: Play Song\n");
        System.out.print("Enter your choice number: ");
        Scanner scan_choice= new Scanner(System.in);
        choice = scan_choice.nextInt();
        System.out.print("You have entered "+ choice +"\n");

        if (choice == 1) { //choice is music recommender

            Scanner scan = new Scanner(System.in);
            System.out.print("Enter a Genre: ");
            String genre_1 = scan.nextLine();
            System.out.print("You have entered: " + genre_1 + "\n");
            Music_System music = new Music_System();
            music.Music_Recommender(genre_1);

        }
        else if (choice == 2) { //choice is plagiarism checker and inserting song

            //variables for entering the new in database
            int s_ID_temp = 0; //song_ID
            int a_ID_temp = 0; //album_ID
            String name_temp = ""; //song name
            int dur_temp = 0; //duration
            String genre_temp = ""; //genre
            int year_temp = 0; //year
            String lyrics_file_temp = "";  //lyrics file
            String lyrics_temp = "";  //lyrics
            String data_1[] = new String[3000];
            String album_name_temp = "";
            int album_year_temp = 0;

            Scanner scan_album_name = new Scanner(System.in);
            System.out.print("Enter Album Name: ");
            album_name_temp = scan_album_name.nextLine();
            System.out.print("You have entered: "+ album_name_temp + "\n");

            Scanner scan_album_year = new Scanner(System.in);
            System.out.print("Enter Album Release Year: ");
            album_year_temp = scan_album_year.nextInt();
            System.out.print("You have entered: "+ album_year_temp + "\n");

            Scanner scan_name = new Scanner(System.in);
            System.out.print("Enter Song Name: ");
            name_temp = scan_name.nextLine();
            System.out.print("You have entered: "+ name_temp + "\n");

            Scanner scan_duration = new Scanner(System.in);
            System.out.print("Enter Song Duration: ");
            dur_temp = scan_duration.nextInt();
            System.out.print("You have entered: "+ dur_temp + "\n");

            Scanner scan_genre = new Scanner(System.in);
            System.out.print("Enter Song Genre: ");
            genre_temp = scan_genre.nextLine();
            System.out.print("You have entered: "+ genre_temp + "\n");

            Scanner scan_year = new Scanner(System.in);
            System.out.print("Enter Song Year: ");
            year_temp = scan_year.nextInt();
            System.out.print("You have entered: "+ year_temp + "\n");

            Scanner scan_lyrics = new Scanner(System.in);
            System.out.print("Enter Song Lyrics File Name: ");
            lyrics_file_temp = scan_lyrics.nextLine();
            System.out.print("You have entered: "+ lyrics_file_temp + "\n");

            Music_System music = new Music_System();
            music.Plagiarism_Checker(s_ID_temp ,a_ID_temp ,name_temp,dur_temp ,genre_temp ,
                    year_temp , lyrics_file_temp , lyrics_temp , data_1 , album_name_temp,album_year_temp);

        }
        else if (choice ==3){ //choice is create account

            String name = ""; //user real name
            String user_name = "";
            String email = ""; //username email
            String password = ""; //user account password
            String temp_password = ""; //to match password entered is correct
            String gender;

            CreditCard credentials = new CreditCard(); //for credit card details

            int credit_card_number = 0; //user credit card details
            int credit_card_pin = 0; //user credit card details

            Music_System music = new Music_System();

            System.out.print("Enter your full name: ");
            Scanner scan_name = new Scanner(System.in);
            name = scan_name.nextLine();
            System.out.print("You have entered: "+ name + "\n");

            System.out.print("Enter your username: ");
            int temp = 0; // bool condition variable for username
            while (temp == 0){

                Scanner scan_username = new Scanner(System.in);
                user_name = scan_username.nextLine();
                System.out.print("You have entered: "+ user_name + "\n");

                temp = music.check_username_availability(user_name); //checking if username available or not

                if (temp==0){
                    System.out.print("Sorry, username not available\n");
                    System.out.print("Enter your username again: ");
                }

            }

            System.out.print("Enter your credit card number: ");
            Scanner scan_credit_card_number = new Scanner(System.in);
            credit_card_number = scan_credit_card_number.nextInt();
            System.out.print("You have entered: "+ credit_card_number + "\n");

            System.out.print("Enter your credit card pin: ");
            Scanner scan_credit_card_pin = new Scanner(System.in);
            credit_card_pin = scan_credit_card_pin.nextInt();
            System.out.print("You have entered: "+ credit_card_pin + "\n");

            System.out.print("Enter your email: ");
            Scanner scan_email = new Scanner(System.in);
            email = scan_email.nextLine();
            System.out.print("You have entered: "+ email + "\n");

            System.out.print("Enter your password: ");
            Scanner scan_password = new Scanner(System.in);
            password = scan_password.nextLine();
            System.out.print("You have entered: "+ password + "\n");

            System.out.print("Enter your password again: ");
            Scanner scan_temp_password = new Scanner(System.in);
            temp_password = scan_temp_password.nextLine();
            System.out.print("You have entered: "+ temp_password + "\n");

            int temp_1 = 0; // bool variable to check both passwords are correct
            while (temp_1 == 0){
                if (temp_password.equals(password)){
                    temp_1 = 1;
                }
                else{
                    System.out.print("Sorry, both passwords do not match.\n");
                    System.out.print("Enter you password again: ");
                    scan_temp_password = new Scanner(System.in);
                    temp_password = scan_temp_password.nextLine();
                    System.out.print("You have entered: "+ temp_password + "\n");
                }
            }

            System.out.print("Enter your gender: ");
            Scanner scan_gender = new Scanner(System.in);
            gender = scan_gender.nextLine();
            System.out.print("You have entered: "+ gender + "\n");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter your DOB in format (YYYY-MM-DD):");
            System.out.print("Enter date: ");
            String str = sc.nextLine();
            Date date = null;

            try {
                date = sdf.parse(str);

                sdf = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println("Date: " + sdf.format(date));
            } catch (ParseException e) {
                System.out.println("Parse Exception");
            }

            credentials.setCard_Number(credit_card_number);
            credentials.setPIN(credit_card_pin);

            int temp_2 = music.Create_User_Account(name,user_name, date, gender, credentials, email,password); //creating user account

            if (temp_2 == 1){
                System.out.print("Account Created !\n");
            }
            else{
                System.out.print("ERROR ! Account not Created !\n");
                System.out.print("Entered pin is incorrect !\n");
            }

        }

        if (choice == 4) { //choice is to play songs
            Music_System music = new Music_System();
            music.play_song();
        } */
    }
}
