package sample;

import com.mysql.cj.log.Log;
//import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.animation.RotateTransition;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;

//import java.io.IOException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.io.IOException;
//import java.util.stream.IntStream;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.application.Platform;

public class StartUpController implements Initializable {
    int i;

    @FXML
    private javafx.scene.control.ProgressBar ProgressBar;
    @FXML
    private Label progressLabel;
    @FXML
    private StackPane rootPane;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        // int i;
        System.out.println("Entered!!");
        Task<Void> task = new Task<Void>() {

            @Override
            protected Void call() throws Exception {
                ProgressBar.setStyle("-fx-accent:#2F131E");
                // label.setText("MAHA");
                for (i = 0; i <= 100; i++) {
                    //System.out.println("Print");
                    updateProgress(i, 100);
                     System.out.println(i);
                    String str3 = String.valueOf(i);
                    System.out.println(str3);
                    //     label.setText(str3);
                    Thread.sleep(30);
                    //percentLabel.setText(String.valueOf(i));
                }
                i--;
                System.out.println("i= " + i);
                if(i==100)
                {
                    new StartUp().start();
                }


                return null;
            }
        };
        ProgressBar.progressProperty().unbind();
        ProgressBar.progressProperty().bind(task.progressProperty());

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();



    }

    class StartUp extends Thread
    {
        @Override
        public void run(){
            try{
                System.out.println("Entered!!");
                Thread.sleep(50);

                javafx.application.Platform.runLater(new Runnable(){
                    @Override
                    public void run() {

                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Stage stage = new Stage();
                        stage.setTitle("MUSIC MANAGEMENT SYSTEM");
                        stage.setScene(new Scene(root, 1000, 653));
                        stage.show();
                    }
                });
            }
            catch (InterruptedException ex){
                Logger.getLogger(StartUpController.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }


}
