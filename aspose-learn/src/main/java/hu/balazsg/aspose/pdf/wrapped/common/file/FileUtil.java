package hu.balazsg.aspose.pdf.wrapped.common.file;

import java.io.*;

public class FileUtil {

    public static FileInputStream getFileStreamSafe(String pathToFile) {
        java.io.FileInputStream imageStream = null;
        try {
            imageStream = new java.io.FileInputStream(new java.io.File(pathToFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return imageStream;
    }

    public static void closeFileStreamSafe(FileInputStream fileInputStream) {
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
