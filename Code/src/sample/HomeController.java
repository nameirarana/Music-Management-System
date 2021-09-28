package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeController implements Initializable {

    @FXML
    private ImageView forwardLogoImage ;
    @FXML
    private ImageView backwardLogoImage ;
    @FXML
    private ImageView playbuttonLogoImage ;
    @FXML
    private ImageView backwardRewindLogoImage ;
    @FXML
    private ImageView resetLogoImage ;
    @FXML
    private ImageView forwardRewindLogoImage ;
    @FXML
    private ImageView logoImageView ;
    @FXML
    private ImageView searchLogoImage ;
    @FXML
    private ImageView homeImageView ;
    @FXML
    private ImageView browseLogoImage ;
    @FXML
    private ImageView favImageView ;
    @FXML
    private ImageView artistLogoImage ;
    @FXML
    private ImageView songImageView ;
    @FXML
    private ImageView albumLogoImage ;
    @FXML
    private ImageView taylorImageView ;
    @FXML
    private ImageView duaLogoImage ;
    @FXML
    private ImageView youngImageView ;
    @FXML
    private ImageView phoebeLogoImage ;
    @FXML
    private ImageView saintImageView ;
    @FXML
    private ImageView willowLogoImage ;
    @FXML
    private ImageView perfectImageView ;
    @FXML
    private ImageView charlieLogoImage ;
    @FXML
    private ImageView closerImageView ;
    @FXML
    private ImageView favImageView1;
    @FXML
    private ImageView favImageView2;
    @FXML
    private ImageView favImageView3;
    @FXML
    private ImageView favImageView4;
    @FXML
    private ImageView playLogoImage2;
    @FXML
    private ImageView playLogoImage1;
    @FXML
    private ImageView playLogoImage3;
    @FXML
    private ImageView playLogoImage4;
    @FXML
    private Label play1Label;

    @FXML
    private Label play2Label;

    @FXML
    private Label play3Label;

    File playbuttonimageFile ;
    String username;
    String password;

    Music_System music = new Music_System();

    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Logo Image
        File logoimageFile=new File("logo-white.png") ;
        Image logoImage=new Image(logoimageFile.toURI().toString()) ;
        logoImageView.setImage(logoImage) ;

        //Search Image
        File searchimageFile=new File("noun_Search_1439107.png") ;
        Image searchImage=new Image(searchimageFile.toURI().toString()) ;
        searchLogoImage.setImage(searchImage) ;

        //Play Pause Button
        playbuttonimageFile=new File("noun_play_3656231.png") ;
        Image playbuttonImage=new Image(playbuttonimageFile.toURI().toString()) ;
        playbuttonLogoImage.setImage(playbuttonImage) ;

        File forwardimageFile=new File("fill_forward.png") ;
        Image forwardImage=new Image(forwardimageFile.toURI().toString()) ;
        forwardLogoImage.setImage(forwardImage) ;

        File backwardimageFile=new File("fill-backward.png") ;
        Image backwardImage=new Image(backwardimageFile.toURI().toString()) ;
        backwardLogoImage.setImage(backwardImage) ;

        File resetimageFile=new File("reset.png") ;
        Image resetImage=new Image(resetimageFile.toURI().toString()) ;
        resetLogoImage.setImage(resetImage) ;

        File forwardRewindimageFile=new File("forward button.png") ;
        Image forwardRewindImage=new Image(forwardRewindimageFile.toURI().toString()) ;
        forwardRewindLogoImage.setImage(forwardRewindImage) ;

        File backwardRewindimageFile=new File("rewind button.png") ;
        Image backwardRewindImage=new Image(backwardRewindimageFile.toURI().toString()) ;
        backwardRewindLogoImage.setImage(backwardRewindImage) ;

        File homeimageFile=new File("home.png") ;
        Image homeImage=new Image(homeimageFile.toURI().toString()) ;
        homeImageView.setImage(homeImage) ;

        File favimageFile=new File("noun_Heart_1688837.png") ;
        Image favImage=new Image(favimageFile.toURI().toString()) ;
        favImageView.setImage(favImage) ;
        favImageView1.setImage(favImage) ;
        favImageView2.setImage(favImage) ;
        favImageView3.setImage(favImage) ;
        favImageView4.setImage(favImage) ;

        File browseimageFile=new File("noun_Search_1439107.png") ;
        Image browseImage=new Image(browseimageFile.toURI().toString()) ;
        browseLogoImage.setImage(browseImage) ;

        File artistimageFile=new File("noun_User_1877134.png") ;
        Image artistImage=new Image(artistimageFile.toURI().toString()) ;
        artistLogoImage.setImage(artistImage) ;

        File songimageFile=new File("Music.png") ;
        Image songImage=new Image(songimageFile.toURI().toString()) ;
        songImageView.setImage(songImage) ;

        File albumimageFile=new File("noun_Album_1564611.png") ;
        Image albumImage=new Image(albumimageFile.toURI().toString()) ;
        albumLogoImage.setImage(albumImage) ;

        File taylorimageFile=new File("Taylor_Swift_-_Evermore.png") ;
        Image taylorImage=new Image(taylorimageFile.toURI().toString()) ;
        taylorImageView.setImage(taylorImage) ;

        File duaimageFile=new File("Dua_Lipa_-_Future_Nostalgia_(Official_Album_Cover).png") ;
        Image duaImage=new Image(duaimageFile.toURI().toString()) ;
        duaLogoImage.setImage(duaImage) ;

        File youngimageFile=new File("220px-YoungBoy_Never_Broke_Again_-_Top.png") ;
        Image youngImage=new Image(youngimageFile.toURI().toString()) ;
        youngImageView.setImage(youngImage) ;

        File phoebeimageFile=new File("Phoebe_Bridgers_Punisher_(2020).png") ;
        Image phoebeImage=new Image(phoebeimageFile.toURI().toString()) ;
        phoebeLogoImage.setImage(phoebeImage) ;

        File saintimageFile=new File("Saint Cloud_Waxahatchee.jpg") ;
        Image saintImage=new Image(saintimageFile.toURI().toString()) ;
        saintImageView.setImage(saintImage) ;

        File willowimageFile=new File("Taylor_Swift_-_Evermore.png") ;
        Image willowImage=new Image(willowimageFile.toURI().toString()) ;
        willowLogoImage.setImage(willowImage) ;

        File perfectimageFile=new File("Ed_Sheeran_Perfect_Single_cover.jpg") ;
        Image perfectImage=new Image(perfectimageFile.toURI().toString()) ;
        perfectImageView.setImage(perfectImage) ;

        File closerimageFile=new File("Something_Just_Like_This.png") ;
        Image closerImage=new Image(closerimageFile.toURI().toString()) ;
        closerImageView.setImage(closerImage) ;

        File charlieimageFile=new File("MV5BOWQyYmJiOWUtNzkzYS00YWJlLWI5YjgtYTg4MjI0MmM1N2ZkXkEyXkFqcGdeQXVyNjE0ODc0MDc@._V1_.jpg") ;
        Image charlieImage=new Image(charlieimageFile.toURI().toString()) ;
        charlieLogoImage.setImage(charlieImage) ;

        File playimageFile=new File("noun_play button_1851805.png") ;
        Image playImage=new Image(playimageFile.toURI().toString()) ;
        playLogoImage1.setImage(playImage) ;
        playLogoImage2.setImage(playImage) ;
        playLogoImage3.setImage(playImage) ;
        playLogoImage4.setImage(playImage) ;


    }

    public void playButtonOnClicked() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        UserHolder holder = UserHolder.getInstance();
        Users u = holder.getUser();
        username = u.getusername();
        password = u.getPassword();
        System.out.println(username);

        System.out.println("PLAY BUTTON CLICKED\n");
        String file_Path = "C:\\Users\\Dell\\Desktop\\Music Management System\\src\\sample\\willow .wav";
        Music_System music = new Music_System(file_Path);
        music.play_song(3);


    }

    public void favButtonOnClicked()
    {

    }

    @FXML
    void favViewButtonOnClicked() {

    }

    @FXML
    void SongButtonOnClicked() {

    }

    @FXML
    void albumButtonOnclicked() {

    }

    @FXML
    void browseButtonOnClicked() {

    }

    @FXML
    void Forward10Sec() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        System.out.println("FORWARD 10 SEC CLICKED\n");

        String file_Path = "C:\\Users\\Dell\\Desktop\\Music Management System\\src\\sample\\willow .wav";
        Music_System music = new Music_System(file_Path);
        music.play_song(5);
    }


}
