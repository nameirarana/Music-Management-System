package sample;

public class Playlist{
    String name;
    int playlist_ID;
    int song_ID;
    int library_ID;

    Playlist() {
        name = null;
        playlist_ID = 0;
        song_ID = 0;
        library_ID = 0;
    }

    Playlist(String pname, int pplaylistid, int psongid, int plibraryid ){
        name = pname;
        playlist_ID = pplaylistid;
        song_ID = psongid;
        library_ID = plibraryid;
    }
}
