package com.baebin.MultiArrayExperiment.data;

import com.baebin.MultiArrayExperiment.util.Debugger;

import java.util.ArrayList;
import java.util.List;

public class Info {
    private static final String TAG = "Info";

    // School / Grade / Class / Number / Subject
    public static final List<String> CATEGORY = new ArrayList<>();
    public static final List<String> SCHOOL = new ArrayList<>();
    public static final List<Integer> GRADE = new ArrayList<>();
    public static final List<Integer> CLASS = new ArrayList<>();
    public static final List<Integer> NUMBER = new ArrayList<>();
    public static final List<String> SUBJECT = new ArrayList<>();

    static public void init() {
        Debugger.p(TAG, "init()");

        CATEGORY.add("SCHOOL");
        CATEGORY.add("GRADE");
        CATEGORY.add("CLASS");
        CATEGORY.add("NUMBER");
        CATEGORY.add("SUBJECT");

        SCHOOL.add("Shincheon");
        SCHOOL.add("Sorae");
        SCHOOL.add("Eunhaeng");

        for (int i = 1; i <= 3; i++) {
            GRADE.add(i);
        }
        for (int i = 1; i <= 10; i++) {
            CLASS.add(i);
        }
        for (int i = 1; i <= 30; i++) {
            NUMBER.add(i);
        }

        SUBJECT.add("Math");
        SUBJECT.add("Language");
        SUBJECT.add("English");
    }

    static public void clear() {
        Debugger.p(TAG, "clear()");

        CATEGORY.clear();
        SCHOOL.clear();
        GRADE.clear();
        CLASS.clear();
        NUMBER.clear();
        SUBJECT.clear();
    }
}