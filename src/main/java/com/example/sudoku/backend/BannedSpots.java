package com.example.sudoku.backend;

public class BannedSpots {
    int[][] startingPosition = new int[1][2];
    BannedSpot[] bannedSpots = new BannedSpot[18];

    public BannedSpots() {
        for (int i = 0; i < bannedSpots.length; i++) {
            bannedSpots[i] = new BannedSpot();
        }
    }
}