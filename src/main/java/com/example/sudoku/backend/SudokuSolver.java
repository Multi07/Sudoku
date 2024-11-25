package com.example.sudoku.backend;
import java.util.List;

public class SudokuSolver {

    public static boolean isSafeToPlace(Sudoku s, int row, int col, int num) {
        // Check row
        for (int x = 0; x < 9; x++) {
            if (s.board[row][x] == num) return false;
        }

        // Check column
        for (int x = 0; x < 9; x++) {
            if (s.board[x][col] == num) return false;
        }

        // Check 3x3 grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s.board[startRow + i][startCol + j] == num) return false;
            }
        }

        return true;
    }

    public static boolean solveSudoku(Sudoku s) {
        // Find an empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (s.board[row][col] == 0) { // Empty cell
                    // Try placing digits 1-9
                    for (int num = 1; num <= 9; num++) {
                        if (isSafeToPlace(s, row, col, num)) {
                            s.board[row][col] = num;

                            // Recursively attempt to solve
                            if (solveSudoku(s)) {
                                return true;
                            }

                            // Backtrack
                            s.board[row][col] = 0;
                        }
                    }

                    // If no number can be placed, return false
                    return false;
                }
            }
        }

        // If the board is completely filled, return true
        return true;
    }
}

