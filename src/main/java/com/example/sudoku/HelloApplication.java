package com.example.sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("Sudoku Time!");


        GridPane root = new GridPane();
        int o =0;
        int l =0;
        for (int i =0;i<81;i++) {
            TextField txt = new TextField();
            if (o<9) {
                root.add(txt, o, l);
                o++;
            }else {
                l++;
                o=0;
                i--;
            }
        }

        Scene scene = new Scene(root, 320, 240);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}