package com.example.sudoku;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    ArrayList<Integer> list = new ArrayList<>();
    private GridPane root = new GridPane();
    private TextField[][] cells = new TextField[9][9];


    Button btn1 = new Button("Řešení");
    Button btn2 = new Button("Restart");



    public void initialize() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                TextField cell = new TextField();
                cell.setPrefWidth(50);
                cell.setPrefHeight(50);
                cell.setText("");
                root.add(cell, col, row);
                cells[row][col] = cell;
            }
        }
    }




    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        stage.setTitle("Sudoku Time!");



        btn2.setOnAction(event -> {
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    cells[row][col].setText("");
                }
            }
        });
        btn1.setOnAction(event -> {
            System.out.println("Řešení Sudoku není implementováno");
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    cells[row][col].getText();
                }
            }
        });

        initialize();


        root.add(btn1, 3,12,2,1);
        root.add(btn2, 5,12,2,1);

        Scene scene = new Scene(root, 320, 240);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}