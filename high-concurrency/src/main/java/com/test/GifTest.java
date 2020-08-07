package com.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author Administrator
 */
public class GifTest {
    public GifTest() {
    }

    public static void get(String urls , String path){
        try {
            URL url = new URL(urls);
            java.io.BufferedInputStream bis = new BufferedInputStream(url
                    .openStream());
            byte[] bytes = new byte[1024];
            OutputStream bos = new FileOutputStream(new File(
                    path));
            int len;
            while ((len = bis.read(bytes)) > 0) {
                bos.write(bytes, 0, len);
            }
            bis.close();
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GifTest.get("https://tukuimg.bdstatic.com/scrop/9841583bd22d963a1035e6c3bc9aba14.gif","E:\\Test\\test1.gif");

    }

}
