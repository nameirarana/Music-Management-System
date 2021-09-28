package sample;

public class Album{
    String name;
    int year;
    int album_ID;
    int artist_ID;

    Album() {
        name = null;
        year = 0;
        album_ID = 0;
        artist_ID = 0;
    }

    Album(String aname, int ayear, int aalbumid, int aartistid ){
        name = aname;
        year = ayear;
        album_ID = aalbumid;
        artist_ID = aartistid;
    }

    Album(String aname, int ayear,  int aartistid ){
        name = aname;
        year = ayear;
        artist_ID = aartistid;
    }
}