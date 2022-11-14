package com.example.demo4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public ImageView memory;
    public ImageView iq;
    public ImageView education;
    public ImageView vocabulary;
    public ImageView gk;
    public ImageView entertainment;
    public Button right;
    public Button left;
    public ImageView image;
    public Label gamename;
    public final ImageView[] games=new ImageView[6];
    public String names[];
    /*index-   0     1    2        3         4     5
    game-    memory iq education vocabulary gk entertainment
     */
    int gamesIndex=0;

    public void leftfn() throws IOException{
        games[gamesIndex].setVisible(false);
        gamesIndex=(gamesIndex-1);
        if(gamesIndex==-1) gamesIndex=5;
        games[gamesIndex].setVisible(true);
        gamename.setText(names[gamesIndex]);
    }
    public void rightfn() throws IOException{
        games[gamesIndex].setVisible(false);
        gamesIndex=(gamesIndex+1)%6;
        games[gamesIndex].setVisible(true);
        gamename.setText(names[gamesIndex]);
    }
    public int memoryfn() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/fxmlfile/memory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        Stage stclose=(Stage)(gamename.getScene().getWindow());
        stclose.close();
        stage.show();
        return gamesIndex;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i=0;i<6;++i) games[i]=new ImageView();
        games[0]=memory;
        games[1]=iq;
        games[2]=education;
        games[3]=vocabulary;
        games[4]=gk;
        games[5]=entertainment;

        names=new String[6];
        names[0]="memory";
        names[1]="iq";
        names[2]="education";
        names[3]="vocabulary";
        names[4]="gk";
        names[5]="entertainment";
    }
}

