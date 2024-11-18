package com.example.sudoku.backend;
import java.util.List;

public class SudokuSolver {

    public static BannedSpots getAllBannedSpots(int x, int y) {
        BannedSpots bs = new BannedSpots();
        bs.startingPosition[0][0] = x;
        bs.startingPosition[0][1] = y;

        int bannedIndex = 0;

        // Check column conflicts
        for (int col = 0; col < 9; col++) {
            if (col == y) continue;

            List<Integer> position = List.of(x, col);
            bs.bannedSpots[bannedIndex].bannedPosition.add(position);
            bannedIndex++;
        }

        // Check row conflicts
        for (int row = 0; row < 9; row++) {
            if (row == x) continue;

            List<Integer> position = List.of(row, y);
            bs.bannedSpots[bannedIndex].bannedPosition.add(position);
            bannedIndex++;
        }

        return bs;
    }

    public static boolean isSafeToPlace(Sudoku s, int num, BannedSpots bs) {
        for (int i = 0; i < 18; i++) {
            for (List<Integer> pos : bs.bannedSpots[i].bannedPosition) {
                int row = pos.get(0);
                int col = pos.get(1);
                if (s.board[row][col] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean solveSudoku(Sudoku s) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                if (s.board[x][y] == 0) {
                    BannedSpots bs = getAllBannedSpots(x, y);

                    for (int num = 1; num <= 9; num++) {
                        if (isSafeToPlace(s, x, bs)) {
                            s.board[x][y] = num;

                            if (solveSudoku(s)) {
                                return true;
                            }

                            s.board[x][y] = 0;
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }
}
