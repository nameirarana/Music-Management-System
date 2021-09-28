package sample;

public class Artist{

    private int artist_ID;
    private String record_Label;
    private int user_ID;

    public Artist(){

        record_Label = "";
        user_ID = -1;
        artist_ID=-1;
    }

    public Artist(String rlabel , int uid, int aid){

        record_Label=rlabel;
        user_ID = uid;
        artist_ID=aid;
    }
}
