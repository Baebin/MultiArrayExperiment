package com.baebin.MultiArrayExperiment.data;

import com.baebin.MultiArrayExperiment.util.Debugger;

import java.util.Random;

public class DataGenerator {
    private static final String TAG = "DataGenerator";
    private static int[][][][][] data;

    public DataGenerator() {
        Debugger.p(TAG, "DataGenerator");
        init();
    }

    private static void init() {
        Debugger.p(TAG, "init()");

        // School / Grade / Class / Number / Subject
        data = new int[Info.SCHOOL.size()][Info.GRADE.size()][Info.CLASS.size()][Info.NUMBER.size()][Info.SUBJECT.size()];

        int stack = 0;
        for (int i = 0; i < Info.SCHOOL.size(); i++) {
            for (int j = 0; j < Info.GRADE.size(); j++) {
                for (int k = 0; k < Info.CLASS.size(); k++) {
                    for (int l = 0; l < Info.NUMBER.size(); l++) {
                        for (int m = 0; m < Info.SUBJECT.size(); m++) {
                            data[i][j][k][l][m] = getInt(0, 100);
                            stack++;
                        }
                    }
                }
            }
        }

        Debugger.p(TAG, "generated: " + stack);
    }

    public static int[][][][][] getData() {
        return data;
    }

    private static int getInt(int start, int size) {
        Debugger.p(TAG, "getInt(" + start + ", " + size + ")");

        Random random = new Random();
        int num = random.nextInt(size)
                + start;

        Debugger.p(TAG, "num: " + num);
        return num;
    }
}