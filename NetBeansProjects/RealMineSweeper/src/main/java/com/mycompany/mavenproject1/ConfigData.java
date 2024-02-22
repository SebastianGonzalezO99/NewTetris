/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.LevelType.BEGINER;
import static com.mycompany.mavenproject1.LevelType.CRAZY;
import static com.mycompany.mavenproject1.LevelType.DIFFICULT;
import static com.mycompany.mavenproject1.LevelType.INTERMEDIATE;

/**
 *
 * @author alu13114532
 */
public class ConfigData {

    public static final int NUM_ROWS_BEGINER = 10;
    public static final int NUM_COLS_BEGINER = 10;
    public static final int RATIO_BEGINNER = 10; //10%

    public static final int NUM_ROWS_INTERMEDIATE = 16;
    public static final int NUM_COLS_INTERMEDIATE = 16;
    public static final int RATIO_INTERMEDIATE = 15; //15%

    public static final int NUM_ROWS_DIFICULT = 25;
    public static final int NUM_COLS_DIFICULT = 25;
    public static final int RATIO_DIFICULT = 20; //20%
    
    public static final int NUM_ROWS_CRAZY = 30;
    public static final int NUM_COLS_CRAZY = 30;
    public static final int RATIO_CRAZY = 30; //30%

    private static ConfigData instance;
    private LevelType level;

    private ConfigData() {
        level = LevelType.BEGINER;
    }

    public static ConfigData getInstance() {
        if (instance == null) {
            instance = new ConfigData();
        }
        return instance;
    }

    public int getRows() {
        switch (level) {
            case BEGINER:
                return NUM_ROWS_BEGINER;
            case INTERMEDIATE:
                return NUM_ROWS_INTERMEDIATE;
            case DIFFICULT:
                return NUM_ROWS_DIFICULT;
            case CRAZY:
                return NUM_ROWS_CRAZY;
            default:
                throw new RuntimeException("Unkown Level");
        }
    }
    
        public int getCols() {
        switch (level) {
            case BEGINER:
                return NUM_COLS_BEGINER;
            case INTERMEDIATE:
                return NUM_COLS_INTERMEDIATE;
            case DIFFICULT:
                return NUM_COLS_DIFICULT;
            case CRAZY:
                return NUM_COLS_CRAZY;
            default:
                throw new RuntimeException("Unkown Level");
        }
    }
        
            public int getRatio() {
        switch (level) {
            case BEGINER:
                return RATIO_BEGINNER;
            case INTERMEDIATE:
                return RATIO_INTERMEDIATE;
            case DIFFICULT:
                return RATIO_DIFICULT;
            case CRAZY:
                return RATIO_CRAZY;
            default:
                throw new RuntimeException("Unkown Level");
        }
    }

}
