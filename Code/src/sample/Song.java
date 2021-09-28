package sample;

//package net.javastring.strings;
import java.nio.file.*;;
import java.awt.*;
import java.io.IOException;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class Song{
    String name;
    int duration;
    String genre;
    int year;
    ArrayList<String> lyrics;
    String lyrics_1;
    int album_ID ;
    int song_ID;

    public Song() {
        name = null;
        duration = 0;
        genre = null;
        year = 0;
        lyrics = new ArrayList<String>();
        album_ID = 0;
        song_ID = 0;
        lyrics_1 = "";
    }

    public Song(String sname, int sduration, String sgenre, int syear, String lyrics_temp, int salbumid, int ssongid ){
        name = sname;
        duration = sduration;
        genre = sgenre;
        year = syear;
        album_ID = salbumid;
        song_ID = ssongid;

        /*
        String data = "";
        //System.out.println("\nFILE 1\n");
        try {
            data = new String(Files.readAllBytes(Paths.get(file)));
        }

        catch (IOException e){
            e.printStackTrace();
        }
        */

        String[] str = lyrics_temp.split(" // ");
        lyrics = new ArrayList<String>(Arrays.asList(str));
    }

    public Song(String sname, int sduration, String sgenre, int syear, String lyrics_temp, int salbumid ){
        name = sname;
        duration = sduration;
        genre = sgenre;
        year = syear;
        album_ID = salbumid;

        /*
        String data = "";
        //System.out.println("\nFILE 1\n");
        try {
            data = new String(Files.readAllBytes(Paths.get(file)));
        }

        catch (IOException e){
            e.printStackTrace();
        }
        */

        //String[] str = lyrics_temp.split(" // ");
        //lyrics = new ArrayList<String>(Arrays.asList(str));
        lyrics_1 = lyrics_temp;
    }

    public void reinitialize(String sname, int sduration, String sgenre, int syear, String file, int salbumid, int ssongid ){
        name = sname;
        duration = sduration;
        genre = sgenre;
        year = syear;
        album_ID = salbumid;
        song_ID = ssongid;

        String data = "";
        System.out.println("\n" + sname + "\n");
        try {
            data = new String(Files.readAllBytes(Paths.get(file)));
        }

        catch (IOException e){
            e.printStackTrace();
        }
        String[] str = data.split("\n");
        lyrics = new ArrayList<String>(Arrays.asList(str));
    }

    public String getLyricFile(){
        String filename = name;
        filename +=".txt";
        System.out.println("\nFile Name: " + filename + "\n");
        return filename;

    }

    public ArrayList<String> getLyrics(){

        return lyrics;
    }

    public String getGenre(){

        return genre;
    }

    public String getName(){

        return name;
    }

    public int getSong_Id(){

        return song_ID;
    }

    public String printSong(){

        System.out.println("\nSong\n");
        System.out.println("Name: " + name + "\n");
        System.out.println("Duration: " + duration + "\n");
        System.out.println("Genre: " + genre + "\n");
        System.out.println("Year: " + year + "\n");
        return "HEY";

    }
}