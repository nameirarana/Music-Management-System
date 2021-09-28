package sample;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.util.*;
public class Library{
    int library_ID;
    ArrayList<Song> library_Songs;

    Library() {
        library_ID = 0;
        library_Songs = new ArrayList<Song>();
    }

    Library(int llibraryid, Song song){
        library_ID = llibraryid;
        library_Songs = new ArrayList<Song>();
        library_Songs.add(song);
    }

}

