package com.baebin.MultiArrayExperiment;

import com.baebin.MultiArrayExperiment.data.DataGenerator;
import com.baebin.MultiArrayExperiment.data.Info;
import com.baebin.MultiArrayExperiment.data.NameGenerator;
import com.baebin.MultiArrayExperiment.manager.FileManager;
import com.baebin.MultiArrayExperiment.util.Debugger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiArrayExperiment {
    private static final String TAG = "MultiArrayExperiment";
    private static int[][][][][] scores;
    private static String[][][][] students;

    public static void main(String[] args) throws IOException {
        Debugger.p(TAG, "main()");

        Info.init();
        scores = new DataGenerator().getData();
        students = new NameGenerator().getData();

        saveCSV();

        Scanner scanner = new Scanner(System.in);
        List<Integer> indexes = new ArrayList<>();
        List<String> categories = Info.CATEGORY;

        pln("");
        do {
            p(">> Type the " + categories.get(indexes.size()) + ": ");
            if (scanner.hasNext()) {
                try {
                    indexes.add(scanner.nextInt());
                    if (indexes.size() == 5) {
                        pln("");
                        pInfo(indexes.get(0), indexes.get(1), indexes.get(2), indexes.get(3), indexes.get(4));
                        indexes.clear();
                        pln("");
                    }
                } catch (NumberFormatException e) {
                    pln("숫자가 올바르지 않습니다.");
                    e.printStackTrace();
                }
            }
        } while (true);
    }

    private static void pInfo(int a, int b, int c, int d, int e) {
        String empty = "     ";
        pln(empty + "Student: <" + students[a][b][c][d] + ">");
        pln(empty + "- School: " + Info.SCHOOL.get(a));
        pln(empty + "- Class: " + Info.CLASS.get(b));
        pln(empty + "- Grade: " + Info.GRADE.get(c));
        pln(empty + "- Number: " + Info.NUMBER.get(d));
        pln(empty + "- " + Info.SUBJECT.get(e) + ": "
                                               + scores[a][b][c][d][e]);
    }

    private static void saveCSV() throws IOException {
        Debugger.p(TAG, "saveCSV()");

        File csv = FileManager.getFile("Data.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(csv));

        bw.write("School,Class,Grade,Number,Subject");
        bw.newLine();

        for (int i = 0; i < Info.NUMBER.size(); i++) {
            if (Info.SCHOOL.size() > i) bw.write(Info.SCHOOL.get(i));
            bw.write(",");
            if (Info.GRADE.size() > i) bw.write(Info.GRADE.get(i).toString());
            bw.write(",");
            if (Info.CLASS.size() > i) bw.write(Info.CLASS.get(i).toString());
            bw.write(",");
            if (Info.NUMBER.size() > i) bw.write(Info.NUMBER.get(i).toString());
            bw.write(",");
            if (Info.SUBJECT.size() > i) bw.write(Info.SUBJECT.get(i));
            bw.newLine();
        }

        bw.flush();
        bw.close();

        saveCSV2();
    }

    private static void saveCSV2() throws IOException {
        Debugger.p(TAG, "saveCSV2()");

        File csv = FileManager.getFile("Students.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(csv));

        bw.write("Name,School,Class,Grade,Number");
        for (int i = 0; i < Info.SUBJECT.size(); i++) {
            bw.write("," + Info.SUBJECT.get(i));
        }
        bw.newLine();

        for (int i = 0; i < Info.SCHOOL.size(); i++) {
            for (int j = 0; j < Info.GRADE.size(); j++) {
                for (int k = 0; k < Info.CLASS.size(); k++) {
                    for (int l = 0; l < Info.NUMBER.size(); l++) {
                        bw.write(students[i][j][k][l] + ",");
                        bw.write(Info.SCHOOL.get(i) + ",");
                        bw.write(Info.GRADE.get(j) + ",");
                        bw.write(Info.CLASS.get(k) + ",");
                        bw.write(Info.NUMBER.get(l).toString());
                        for (int m = 0; m < Info.SUBJECT.size(); m++) {
                            bw.write("," + scores[i][j][k][l][m]);
                        }
                        bw.newLine();
                    }
                }
            }
        }

        bw.flush();
        bw.close();
    }

    private static void p(String data) {
        System.out.print(data);
    }

    private static void pln(String data) {
        System.out.println(data);
    }
}