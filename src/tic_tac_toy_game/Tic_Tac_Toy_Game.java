/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tac_toy_game;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Fr3on
 */
public class Tic_Tac_Toy_Game extends Application {
    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    Button btn5 = new Button();
    
    Button btn6 = new Button();
    Button btn7 = new Button();
    Button btn8 = new Button();
    Button btn9 = new Button();
    @Override
    public void start(Stage primaryStage) {
        
        btn1.setText(" ");
        btn1.setOnAction(event->{
            PlayGame(1,btn1);
        });
        
        btn2.setText(" ");
        btn2.setOnAction(event->{
            PlayGame(2,btn2);
        });
        
        btn3.setText(" ");
        btn3.setOnAction(event->{
            PlayGame(3,btn3);
        });
        
        btn4.setText(" ");
        btn4.setOnAction(event->{
            PlayGame(4,btn4);
        });
        
        btn5.setText(" ");
        btn5.setOnAction(event->{
            PlayGame(5,btn5);
        });
        
        btn6.setText(" ");
        btn6.setOnAction(event->{
            PlayGame(6,btn6);
        });
        
        btn7.setText(" ");
        btn7.setOnAction(event->{
            PlayGame(7,btn7);
        });
        
        btn8.setText(" ");
        btn8.setOnAction(event->{
            PlayGame(8,btn8);
        });
        
        btn9.setText(" ");
        btn9.setOnAction(event->{
            PlayGame(9,btn9);
        });
        
        
        
        
        GridPane gp= new GridPane();
        gp.setAlignment(Pos.CENTER);
        
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(25, 25, 25, 25));
        gp.add(btn1, 0, 0);
        gp.add(btn2, 1, 0);
        gp.add(btn3, 2, 0);
        gp.add(btn4, 0, 1);
        gp.add(btn5, 1, 1);
        gp.add(btn6, 2, 1);
        gp.add(btn7, 0, 2);
        gp.add(btn8, 1, 2);
        gp.add(btn9, 2, 2);
        
        Scene scene = new Scene(gp, 300, 250);
        scene.getStylesheets().add(Tic_Tac_Toy_Game.class.getResource("style.css").toExternalForm());
        primaryStage.setTitle("Tic Tac Toy");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    int active_player=1;
    ArrayList<Integer> player1=new ArrayList<>(); 
    ArrayList<Integer> player2=new ArrayList<>(); 
    void PlayGame(int cell,Button sel_btn){
        System.out.println("cell :"+cell);
        if(active_player==1){
            sel_btn.setText("X");
            player1.add(cell);
            active_player=0;
            Auto_player();
        }else{
            sel_btn.setText("O");
            player2.add(cell);
            active_player=1;
            
            
        }
        sel_btn.setDisable(true);
        checkWinner();
        
    }
    void checkWinner(){
        int winner =-1;
        if(       (player1.contains(1)&&player1.contains(2)&&player1.contains(3))
                ||(player1.contains(1)&&player1.contains(4)&&player1.contains(7))
                ||(player1.contains(1)&&player1.contains(5)&&player1.contains(9))
                ||(player1.contains(2)&&player1.contains(5)&&player1.contains(8))
                ||(player1.contains(4)&&player1.contains(5)&&player1.contains(6))
                ||(player1.contains(3)&&player1.contains(5)&&player1.contains(7))
                ||(player1.contains(3)&&player1.contains(6)&&player1.contains(9))
                ||(player1.contains(7)&&player1.contains(8)&&player1.contains(9)))
        {
            winner=1;
        }
        else if(  (player2.contains(1)&&player2.contains(2)&&player2.contains(3))
                ||(player2.contains(1)&&player2.contains(4)&&player2.contains(7))
                ||(player2.contains(1)&&player2.contains(5)&&player2.contains(9))
                ||(player2.contains(2)&&player2.contains(5)&&player2.contains(8))
                ||(player2.contains(4)&&player2.contains(5)&&player2.contains(6))
                ||(player2.contains(3)&&player2.contains(5)&&player2.contains(7))
                ||(player2.contains(3)&&player2.contains(6)&&player2.contains(9))
                ||(player2.contains(7)&&player2.contains(8)&&player2.contains(9)))
        {
            winner=0;
        }
        if(winner!=-1){
         String mass="";
         if(winner==1){
             mass="player1 X is the winner";
         }
         else if(winner==0){
             mass="player2 O is the winner";
         }
         Alert alert =new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("game info");
         alert.setContentText(mass);
         alert.setHeaderText("playing info");
         alert.show();
         btn1.setDisable(true);
         btn2.setDisable(true);
         btn3.setDisable(true);
         btn4.setDisable(true);
         btn5.setDisable(true);
         btn6.setDisable(true);
         btn7.setDisable(true);
         btn8.setDisable(true);
         btn9.setDisable(true);
         
         
         
         
        }
    }
    void Auto_player(){
    ArrayList<Integer> emptycells=new ArrayList<>();
        for(int cell=1;cell<10;cell++){
            if(!(player1.contains(cell) ||player2.contains(cell))){
                emptycells.add(cell);
            }
        }
        Random rand=new Random();
        int randomindx=rand.nextInt(emptycells.size()-0)+0;
        int cell=emptycells.get(randomindx);
        Button selectedbtn=new Button();
        switch(cell){
            case 1:
                selectedbtn=btn1;
                break;
            case 2:
                selectedbtn=btn2;
                break;
            case 3:
                selectedbtn=btn3;
                break;
            case 4:
                selectedbtn=btn4;
                break;
            case 5:
                selectedbtn=btn5;
                break;
            case 6:
                selectedbtn=btn6;
                break;
            case 7:
                selectedbtn=btn7;
                break;
            case 8:
                selectedbtn=btn8;
                break;
            case 9:
                selectedbtn=btn9;
                break;
            default:
                selectedbtn=btn9;
                break;
        }
        PlayGame(cell, selectedbtn);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
