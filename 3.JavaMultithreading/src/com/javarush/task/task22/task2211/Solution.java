package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset Utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        FileInputStream filein = new FileInputStream(args[0]);
        FileOutputStream fileout = new FileOutputStream(args[1]);

        byte[] buffer = new byte[filein.available()];
        filein.read(buffer);
        String s = new String(buffer,Utf8);
        buffer = s.getBytes(windows1251);
        fileout.write(buffer);
        filein.close();
        fileout.close();

    }
}
