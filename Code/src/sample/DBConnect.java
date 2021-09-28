package sample;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DBConnect {

    String host;
    String uName;
    String uPass;
    Connection con;

    public DBConnect(){
        try {
            host = "jdbc:mysql://localhost:3306/music_management_system";
            uName = "root";
            uPass = "Ch.hadia10";
            con = DriverManager.getConnection(host, uName, uPass);

        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public DBConnect(String s ){
        try {
            host = "jdbc:mysql://localhost:3306/music_management_system";
            uName = "root";
            uPass = "Ch.hadia10";
            con = DriverManager.getConnection(host, uName, uPass);

        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public void DBConnect_Insert_Album(Album temp_album ){
        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            System.out.println("Hello");
            String sql = "INSERT INTO Album(Artist_ID, Name, Year) VALUES(?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,temp_album.artist_ID);
            statement.setString(2, temp_album.name);
            statement.setInt(3, temp_album.year);
            statement.executeUpdate();
            System.out.println("all good");

        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public int DBConnect_Get_Album_ID( Album temp_album ){ //get Album_ID
        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from album where Name = ? ";
            PreparedStatement temp = con.prepareStatement(sql);
            temp.setString(1, temp_album.name);
            ResultSet rs2 = temp.executeQuery();//then execute the statement

            int temp_a_ID = 0;

            while(rs2.next()) {
                temp_a_ID = rs2.getInt("Album_ID"); //Album ID
            }

            return temp_a_ID;
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return 0;
    }

    public void DBConnect_Insert_Song( Song temp_Song ){
        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            //System.out.println("Hello");
            String sql = "INSERT INTO songs(Album_ID, Name, Duration, Genre, Year, Lyrics) VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, temp_Song.album_ID);
            statement.setString(2, temp_Song.name);
            statement.setInt(3, temp_Song.duration);
            statement.setString(4, temp_Song.genre);
            statement.setInt(5, temp_Song.year);
            statement.setString(6, temp_Song.lyrics_1);

            statement.executeUpdate();
            //System.out.println("all good");

        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public int DBConnect_Get_library_ID( int user_ID ){
        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from library where User_ID = ? ";
            PreparedStatement temp = con.prepareStatement(sql);
            temp.setInt(1,user_ID);
            ResultSet rs2 = temp.executeQuery();//then execute the statement

            int temp_a_ID = 0;

            while(rs2.next()) {
                temp_a_ID = rs2.getInt("Library_ID"); //Album ID
            }

            return temp_a_ID;


        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return 0;
    }

    public int[] DBConnect_Get_Songs_Array( int lib_ID ){
        int song[] = new int[200];
        int count = 0;
        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from playlist where Library_ID = ? ";
            PreparedStatement temp = con.prepareStatement(sql);
            temp.setInt(1,lib_ID);
            ResultSet rs2 = temp.executeQuery();//then execute the statement

            while(rs2.next()) {
                int s1 = rs2.getInt("Song_ID"); //Album ID
                song[count] = s1;
                count++;
            }


        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return song;
    }


    public ArrayList<Song> DBConnect_Return_Song(){
        ArrayList<Song> songs = new ArrayList<Song>();
        Song song_temp;

        //variables for reading data from database
        int s_ID = 0; //song_ID
        int a_ID = 0; //album_ID
        String name = ""; //song name
        int dur = 0; //duration
        String genre = ""; //genre
        int year = 0; //year
        String lyrics = "";  //lyrics

        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from songs";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                s_ID = rs.getInt("Song_ID"); //song ID
                a_ID = rs.getInt("Album_ID"); //album ID
                name = rs.getString("Name"); //song name
                dur = rs.getInt("Duration");; //duration
                genre = rs.getString("Genre"); //genre
                year = rs.getInt("Year"); //year
                lyrics = rs.getString("Lyrics") ;  //lyrics

                //String p = s_ID + " " + a_ID + " " + name + " " + dur + " " + genre + " " + year + " " + lyrics;
                //System.out.println(p);

                song_temp = new Song(name, dur, genre, year, lyrics, a_ID, s_ID);
                songs.add(song_temp);

            }

        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }

        return songs;
    }

    public int DBConnect_user_name_availability(String user_name){
        int temp = 0; //bool value

        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from user where User_Name = ? ";
            PreparedStatement temp_1 = con.prepareStatement(sql);
            temp_1.setString(1,user_name);
            ResultSet rs2 = temp_1.executeQuery();//then execute the statement

            String temp_2 = "";

            while(rs2.next()) {
                temp_2 = rs2.getString("User_Name"); // getting the user name for database
                return temp;
            }
            temp = 1;
            return temp;
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return temp;
    }

    public int DBConnect_password_correctness(String user_name, String password){
        int temp = 0; //bool value

        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from user where User_Name = ? ";
            PreparedStatement temp_1 = con.prepareStatement(sql);
            temp_1.setString(1,user_name);
            ResultSet rs2 = temp_1.executeQuery();//then execute the statement

            String temp_2 = "";
            String temp_3 = "";

            while(rs2.next()) {
                temp_2 = rs2.getString("User_Name"); // getting the user name from database
                temp_3 = rs2.getString("Password"); // getting the pass from database

                System.out.print("1: " + temp_2 + " 2: " + temp_3 + "\n");
                System.out.print("1: " + user_name + " 2: " + password + "\n");

                if ((temp_2.equals(user_name)) && (temp_3.equals(password)))
                {
                    return temp;
                }
            }
            temp = 1;
            return temp;
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return temp;
    }

    public int DBConnect_email_availability(String email){
        int temp = 0; //bool value

        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from user where Email = ? ";
            PreparedStatement temp_1 = con.prepareStatement(sql);
            temp_1.setString(1,email);
            ResultSet rs2 = temp_1.executeQuery();//then execute the statement

            String temp_2 = "";

            while(rs2.next()) {
                temp_2 = rs2.getString("Email"); // getting the user name for database
                return temp;
            }
            temp = 1;
            return temp;
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return temp;
    }

    public int DBConnect_enter_credit_card_details(CreditCard credentials){

        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from creditcard where card_number = ? ";
            PreparedStatement temp_1 = con.prepareStatement(sql);
            temp_1.setInt(1,credentials.getCard_Number());
            ResultSet rs2 = temp_1.executeQuery();//then execute the statement

            int temp_2 = 0;
            int temp_3 = 0;

            while(rs2.next()) {
                temp_2 = rs2.getInt("card_number");
                temp_3 = rs2.getInt("PIN");

                System.out.print(temp_2 + "   " + temp_3 + "\n");

                if (temp_3 == credentials.getPIN()){ //checking if the card number already exist, does the pin also matches or not
                    return 1;
                }
                else{
                    return 0;
                }
            }

            String sql_1 = "INSERT INTO creditcard(card_number, PIN) VALUES(?,?)";
            PreparedStatement statement = con.prepareStatement(sql_1);

            statement.setInt(1, credentials.getCard_Number());
            statement.setInt(2, credentials.getPIN());

            statement.executeUpdate();

            return 1;

        }
        catch (SQLException err) {
            System.out.print("Sorry\n");
            System.out.println(err.getMessage());
        }
        return 0;
    }

    public int DBConnect_get_C_ID(int card_number){

        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stat = con.createStatement();
            String sql = "select * from creditcard where card_number = ? ";
            PreparedStatement temp_1 = con.prepareStatement(sql);
            temp_1.setInt(1,card_number);
            ResultSet rs2 = temp_1.executeQuery();//then execute the statement

            int temp_2 = 0;

            while(rs2.next()) {
                temp_2 = rs2.getInt("C_ID"); //getting the credit card id

            }

            return temp_2;

        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return 0;
    }

    public void DBConnect_Insert_Account_In_Database(String name, String user_name, Date DOB, String gender, int temp_C_ID, String email, String password){

        try {
            String host = "jdbc:mysql://localhost:3306/music_management_system";
            String uName = "root";
            String uPass = "Ch.hadia10";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            String sql = "INSERT INTO User(C_ID, Name, User_Name, DOB, Gender, Email, Password) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);



            statement.setInt(1, temp_C_ID);
            statement.setString(2, name);
            statement.setString(3, user_name);
            statement.setDate(4,  new java.sql.Date(DOB.getTime()));
            statement.setString(5,gender);
            statement.setString(6,email);
            statement.setString(7, password);

            statement.executeUpdate();


        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

}


