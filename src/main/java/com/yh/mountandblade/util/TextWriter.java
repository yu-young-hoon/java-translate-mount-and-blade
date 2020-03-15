package com.yh.mountandblade.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextWriter {

    public static void writeText(String path, String text) throws IOException {

        try (FileOutputStream fos = new FileOutputStream(new File(path))) {
            fos.write(text.getBytes());
        }

    }

}
