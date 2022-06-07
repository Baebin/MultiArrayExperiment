package com.baebin.MultiArrayExperiment.util;

public class Debugger {
    private static final String TAG = "[Debug] ";

    static public void p(String file, String data) {
        System.out.println(TAG + file + ".java: " + data);
    }
}