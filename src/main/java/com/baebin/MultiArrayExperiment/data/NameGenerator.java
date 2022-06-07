package com.baebin.MultiArrayExperiment.data;

import com.baebin.MultiArrayExperiment.util.Debugger;
import com.github.javafaker.Faker;

public class NameGenerator {
    private static final Faker faker = new Faker();
    private static final String TAG = "NameGenerator";
    private static String[][][][] data;

    public NameGenerator() {
        Debugger.p(TAG, "NameGenerator");
        init();
    }

    private static void init() {
        Debugger.p(TAG, "init()");

        // School / Grade / Class / Number / Subject
        data = new String[Info.SCHOOL.size()][Info.GRADE.size()][Info.CLASS.size()][Info.NUMBER.size()];

        int stack = 0;
        for (int i = 0; i < Info.SCHOOL.size(); i++) {
            for (int j = 0; j < Info.GRADE.size(); j++) {
                for (int k = 0; k < Info.CLASS.size(); k++) {
                    for (int l = 0; l < Info.NUMBER.size(); l++) {
                        data[i][j][k][l] = getName();
                        stack++;
                    }
                }
            }
        }

        Debugger.p(TAG, "generated: " + stack);
    }

    public static String[][][][] getData() {
        return data;
    }

    private static String getName() {
        String name = faker.name().fullName();

        Debugger.p(TAG, "getName(): " + name);
        return name;
    }
}