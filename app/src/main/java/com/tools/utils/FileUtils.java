package com.tools.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by zze on 8/1/18.
 */

public final class FileUtils {
    public static final String COMPANY_PATH = "com.tools";

    private FileUtils() {
    }

    public static boolean isHasSdCard() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }

    public static File createFile(String path) {
        if (isHasSdCard()) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile(), path);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    return null;
                }
            }
            return file;
        } else {
            return null;
        }
    }

    public static File createFile(String path, String fileName) {
        File file = createFile(path);
        if (file != null) {
            try {
                file = new File(file, fileName);
                if (!file.exists()) {
                    if (!file.createNewFile()) {
                        return null;
                    }
                }
                return file;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

}
