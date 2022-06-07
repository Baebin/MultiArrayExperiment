package com.baebin.MultiArrayExperiment.manager;

import com.baebin.MultiArrayExperiment.util.Debugger;
import com.baebin.MultiArrayExperiment.util.Path;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileManager {
    private static final String TAG = "FileManager";

    private static String dir = "Database";
    private static Map<String, File> file = new HashMap();

    public static void initFile(String file_name) throws IOException {
        Debugger.p(TAG, "initFile(" + file_name + ")");

        String path = Path.get();
        path += "\\"
                + dir
                + "\\"
                + file_name;
        System.out.println(path);

        File mFile = new File(path);
        if (!mFile.getParentFile().exists()) {
            Debugger.p(TAG, "mFile.mkdirs");
            mFile.mkdirs();
        }
        if (!mFile.exists()) {
            Debugger.p(TAG, "mFile·createNewFile");
            mFile.createNewFile();
        }

        file.put(file_name, mFile);
    }

    public static String getDir() {
        Debugger.p(TAG, "getDir()");
        return dir;
    }

    public static File getFile(String key) throws IOException {
        Debugger.p(TAG, "getFile(" + key + ")");

        if (!file.containsKey(key)) initFile(key);
        return file.get(key);
    }

    public static Map<String, File> getFiles() {
        Debugger.p(TAG, "getFiles()");
        return file;
    }
}
