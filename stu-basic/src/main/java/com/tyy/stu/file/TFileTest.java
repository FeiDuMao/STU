package com.tyy.stu.file;

import java.io.RandomAccessFile;


/**
 * 大文件上传：
 * 在前端分片，然后通过RandomAccessFile进行写入
 *
 *
 */
public class TFileTest {


    public static void main(String[] args) {

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("C:/Users/s/1/2/tyyTest02.txt", "rw");


//            randomAccessFile.write("abcdef".getBytes());
            randomAccessFile.seek(10);
            randomAccessFile.write("aaa".getBytes());
            randomAccessFile.close();

            System.out.println("ok");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
