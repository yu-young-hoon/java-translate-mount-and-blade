package com.yh.mountandblade.util;

import com.yh.mountandblade.Application;

import java.io.*;
import java.net.URL;

public class ResourceReader {

    public static String getText(String path) throws IOException {

        final File resourceFile = getFile(path);
        try (FileReader fileReader = new FileReader(resourceFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }
            return stringBuilder.toString();
        }

    }

    private static File getFile(String path) throws UnsupportedEncodingException {

        final ClassLoader classLoader = Application.class.getClassLoader();

        final URL resource = classLoader.getResource(path);
        if (resource == null) {
            throw new IllegalArgumentException("not fount file");
        } else {
            return new File(java.net.URLDecoder.decode(resource.getPath() ,"UTF-8"));
        }

    }

}
