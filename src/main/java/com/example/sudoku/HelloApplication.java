package com.example.sudoku;

import com.example.sudoku.backend.Sudoku;
import com.example.sudoku.backend.SudokuSolver;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloApplication extends Application {
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
                cell.setText("0");
                root.add(cell, col, row);
                cells[row][col] = cell;
                if ((row/3+col/3) %2 == 0) {
                    cell.getStyleClass().add("cell-dark");
                }
                else {
                    cell.getStyleClass().add("cell-light");
                }

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
                    cells[row][col].setText("0");
                }
            }
        });
        btn1.setOnAction(event -> {
            Sudoku s = new Sudoku();
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    s.board[col][row] = Integer.parseInt(cells[col][row].getText());
                }
            }
            System.out.println(Arrays.deepToString(s.board));
            SudokuSolver.solveSudoku(s);
            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    cells[col][row].setText(String.valueOf(s.board[col][row]));
                }
            }
            System.out.println(Arrays.deepToString(s.board));
        });

        initialize();

        root.add(btn1, 2,12,2,1);
        root.add(btn2, 5,12,2,1);

        Scene scene = new Scene(root, 400, 420);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}