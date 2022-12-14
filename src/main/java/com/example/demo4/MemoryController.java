package com.example.demo4;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MemoryController extends HelloController implements Initializable {

    public Label question;
    public RadioButton ans1;
    public ToggleGroup answer;
    public RadioButton ans2;
    public RadioButton ans3;
    public RadioButton ans4;
    public Button Submit;
    public String[] questions;
    public String[][] ans;
    int id, id1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try {
            //String st=names[0];
            //System.out.println(st);
            System.out.printf(String.valueOf(gamesIndex));
            //File file=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memoryques.txt");
            File quesfiles[];
            quesfiles=new File[6];
            quesfiles[0]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memoryques.txt");
            quesfiles[1]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\iqques.txt");
            quesfiles[2]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\educationques.txt");
            quesfiles[3]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\vocabularyques.txt");
            quesfiles[4]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\gkques.txt");
            quesfiles[5]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\entertainmentque.txt");

            File ansfiles[];
            ansfiles=new File[6];
            ansfiles[0]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\memoryans.txt");
            ansfiles[1]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\iqans.txt");
            ansfiles[2]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\educationans.txt");
            ansfiles[3]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\vocabularyans.txt");
            ansfiles[4]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\gkans.txt");
            ansfiles[5]=new File("C:\\Users\\Guest1\\IdeaProjects\\demo4\\src\\main\\resources\\textfiles\\entertainmentans.txt");

            File currentfile=quesfiles[gamesIndex];
            Scanner sc=new Scanner(currentfile);
            questions=new String[3];
            for(int i=0;i<3;i++){
                questions[i]=sc.nextLine();

            }
            question.setText(questions[0]);
            id=0;

            currentfile=ansfiles[gamesIndex];
            sc=new Scanner(currentfile);
            ans=new String[3][4];
            for(int i=0;i<3;i++){
                for (int j = 0; j < 4; j++) {
                    ans[i][j]=sc.nextLine();
                }
                sc.nextLine();
            }
            ans1.setText(ans[0][0]);
            ans2.setText(ans[0][1]);
            ans3.setText(ans[0][2]);
            ans4.setText(ans[0][3]);

            id1=0;


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void submit_korsi()
    {
        question.setText(questions[++id]);
        if(id==2) Submit.setMouseTransparent(true);

        ans1.setText(ans[++id1][0]);
        ans2.setText(ans[id1][1]);
        ans3.setText(ans[id1][2]);
        ans4.setText(ans[id1][3]);
    }
}
