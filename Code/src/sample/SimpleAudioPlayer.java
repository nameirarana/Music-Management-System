package sample;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//package sample;

//import javax.sound.sampled.*;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SimpleAudioPlayer {

    // to store current position
    Long currentFrame;
    Clip clip;
    Long currentframe1;
    // current status of clip
    String status;
    int check=0; //counter working only once
    AudioInputStream audioInputStream;
    static String filePath;

    SimpleAudioPlayer(){}

    public SimpleAudioPlayer(String Path)
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        filePath = Path;
        // create AudioInputStream objectted`
        System.out.println("Constructor");
        check=0;
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        // create clip reference
        clip = AudioSystem.getClip();

    }

    public void gotoChoice(int c)
            throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
        switch (c)
        {
            case 1:
                PauseSong();
                break;
            case 2:
                ResumeSong();
                break;
            case 3:
                RestartSong();
                break;
            case 4:
                stop();
                break;
            case 5:
                JumpSong();
                break;
            case 6:
                BehindSong();
                break;

        }

    }

    public void stop() throws IOException, LineUnavailableException {
        // audioPlayer.play();
        clip.close();
    }

    public void PlaySong() throws IOException, LineUnavailableException {
        // audioPlayer.play();
        System.out.println("PlaySong Function Entered");
        if(check==0) {
            clip.open(audioInputStream);

            check++;
        }
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println("PlaySong Function Entered1");

        clip.start();
        status = "play";
    }

    public void PauseSong() {
        System.out.println("Pause");
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    public void ResumeSong()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        System.out.println("Resume Entered");
        if (status.equals("play"))
        {
            System.out.println("Audio is already "+
                    "being played");
            return;
        }
        clip.close();
        resetAudioStream();
        System.out.println(currentFrame);
        clip.setMicrosecondPosition(currentFrame);
        System.out.println("Going to play song function");
        this.PlaySong();
    }

    private void resetAudioStream()
            throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        System.out.println("Reset Entered");
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        //clip.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println("Reset Exit");
    }

    public void RestartSong() throws IOException, LineUnavailableException,
            UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.PlaySong();
    }

    public void JumpSong()
            throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        long c;
        currentframe1=this.clip.getMicrosecondPosition();
        System.out.println(currentframe1);
        c=currentframe1+3000000;
        //long c = c1.nextLong();
        if (c > 0 && c < clip.getMicrosecondLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.PlaySong();
        }
    }

    public void BehindSong()
            throws UnsupportedAudioFileException, IOException,
            LineUnavailableException{
        long c;
        currentframe1=this.clip.getMicrosecondPosition();
        System.out.println(currentframe1);
        c=currentframe1-3000000;
        //long c = c1.nextLong();
        if (c > 0 && c < clip.getMicrosecondLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.PlaySong();
        }

    }
}
