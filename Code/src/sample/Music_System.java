package sample;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
//package net.javastring.strings;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Music_System  {

    String filePath;
    SimpleAudioPlayer audioPlayer;

    public Music_System()  {
        filePath = "";
        audioPlayer = new SimpleAudioPlayer();
    }

    public Music_System(String file_Path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        filePath = file_Path;
        audioPlayer = new SimpleAudioPlayer(filePath);
    }

    public void Plagiarism_Checker (int s_ID_temp , int a_ID_temp , String name_temp, int dur_temp , String genre_temp ,
                                    int year_temp , String lyrics_file_temp , String lyrics_temp , String data_1[] ,
                                    String album_name_temp, int album_year_temp) throws IOException {
        DBConnect db1 = new DBConnect(); //connection with DB


        int is_plagiarized = 0; // a bool value for checking plagiarism limit exceeds or not

        //int new_s_ID = 0; //the value that would be given to new song added to song

        Date d = new Date(11,13,2001);
        CreditCard c = new CreditCard(1,1,1);
        User user = new User("Humaira", d, "female", "huma", "humaira@gmail.com","13", c,3);
        int lines_matched = 0;
        double percent = 0.0;

        ArrayList<Song> songs = new ArrayList<Song>();
        songs = db1.DBConnect_Return_Song();

        for (int i = 0; i < songs.size(); i++) {
            System.out.println(songs.get(i).printSong());//.getLyricFile());
        }

        lyrics_temp = new String(Files.readAllBytes(Paths.get(lyrics_file_temp)));
        data_1 = lyrics_temp.split(" // ");
        ArrayList<String> lyrics_1 = new ArrayList<String>(Arrays.asList(data_1));
        //System.out.println("\nFILE 1\n");
        int total = lyrics_1.size();

        for(String s : lyrics_1) {
            System.out.println(s);
        }

        for (int i = 0; i < songs.size(); i++) {
            ArrayList<String> lyrics_2 = new ArrayList<String>(songs.get(i).getLyrics());
            lyrics_2.retainAll(lyrics_1);
            System.out.println("Common elements in both Files: ");
            System.out.println(lyrics_2);
            lines_matched = 0;
            for(int j = 0; j < lyrics_2.size(); j++){
                lines_matched++;
            }

            System.out.println("Line Macthed: " + lines_matched);

            percent = ((double)lines_matched/(double)total)*100;
            System.out.println("Percentage of Plagiarism : " + percent);

            if (percent > 50.0) {
                System.out.println("Sorry, Your song cannot be added as it exceed the maximum plagiarism limit.");
                System.out.println("Your song is plagiarised with:" + songs.get(i).getName());
                is_plagiarized = 1;
            }

        }

        if (is_plagiarized == 0) {

            Album temp_album = new Album(album_name_temp,album_year_temp,3);

            db1.DBConnect_Insert_Album(temp_album);

            int temp_a_ID = db1.DBConnect_Get_Album_ID(temp_album);

            Song temp_song = new Song(name_temp,dur_temp,genre_temp,year_temp,lyrics_temp,temp_a_ID);

            db1.DBConnect_Insert_Song(temp_song);

        }

    }

    public void Music_Recommender(String genre_1){

        DBConnect db2 = new DBConnect(); //connection with DB

        int temp_lib_ID = db2.DBConnect_Get_library_ID(2);

        int song_ids[] = new int [200];
        song_ids = db2.DBConnect_Get_Songs_Array(temp_lib_ID);

        for(int s : song_ids){
            System.out.println(s);//.getLyricFile());
        }

        ArrayList<Song> songs = new ArrayList<Song>();
        songs = db2.DBConnect_Return_Song();

        for (int i = 0; i < songs.size(); i++) {
            System.out.println(songs.get(i).printSong());//.getLyricFile());
        }

        ArrayList<Song> songs_temp = new ArrayList<Song>();

        for(int i=0; i<songs.size();i++){
            for(int j=0; j<song_ids.length;j++){
                if (song_ids[j] == songs.get(i).getSong_Id()){
                    songs_temp.add(songs.get(i));
                }
            }
        }

        String genre_temp ;

        for (int i = 0; i < songs_temp.size(); i++) {
            genre_temp = songs_temp.get(i).getGenre();

            for(int j = 0; j < songs.size(); j++){
                if (genre_temp.equals(songs.get(j).getGenre())){
                    System.out.println(songs.get(j).printSong());
                }
            }

        }

    }

    public int check_username_availability(String user_name){

        DBConnect db2 = new DBConnect(); //connection with DB

        int temp = db2.DBConnect_user_name_availability(user_name); //a bool value to username available or not

        return temp;

    }

    public int check_password_correctness(String user_name, String password){

        DBConnect db2 = new DBConnect(); //connection with DB

        int temp = db2.DBConnect_password_correctness(user_name, password); //a bool value to username available or not

        return temp;

    }

    public int check_email_availability(String email){

        DBConnect db2 = new DBConnect(); //connection with DB

        int temp = db2.DBConnect_email_availability(email); //a bool value to username available or not

        return temp;

    }


    public int Create_User_Account(String name, String user_name, Date DOB, String gender, CreditCard credentials, String email, String password){

        DBConnect db2 = new DBConnect(); //connection with DB

        int temp = db2.DBConnect_enter_credit_card_details(credentials); //a bool value to main id available or not

        if (temp == 1){

            int temp_C_ID = 0;

            temp_C_ID = db2.DBConnect_get_C_ID(credentials.getCard_Number());

            db2.DBConnect_Insert_Account_In_Database(name, user_name, DOB, gender, temp_C_ID, email, password);

        }

        return temp;

    }

    public void music_choice(int choice){
        try
        {

            audioPlayer.PlaySong();
            Scanner sc = new Scanner(System.in);

         /*   while (true)
            {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump");
                System.out.println("6. Behind");
                int c = sc.nextInt();
                audioPlayer.gotoChoice(c);
                if (c == 4) {
                    System.out.println("BREAK");
                    break;
                }
            }*/
            audioPlayer.gotoChoice(3);
            System.out.println("BREAK");
            sc.close();
        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }

    public void play_song(int choice) throws UnsupportedAudioFileException, IOException, LineUnavailableException {


    }

}

