package com.school.util;

import com.school.finals.FinalsString;
import sun.misc.BASE64Decoder;

import java.io.*;

/**
 * @Auther: XiTao
 * @Date: 2019/1/4
 * @Field:文件上传
 */
public class UpLoadUtil {


    public static void main(String[] args) {
        inputFileData(FinalsString.PROJECT_STATIC_RESOURCE_PATH_TEXT+"/"+"201901042325383194058.text");


    }
    /**
     *  读取文件数据
     * @param url
     * @return
     */
    public static StringBuilder inputFileData(String url){
        byte[] b = new  byte[1024];
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file = new File(url);
            FileInputStream inputStream = new FileInputStream(file);
            int i = inputStream.read(b);
            while (i!=-1){
               String data =  new String(b,0,i);
                stringBuilder.append(data);
                i = inputStream.read(b);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder;

    }


    /**
     * 字符串写入
     * @param data 写入的数据
     * @param fileName 文件名称
     * @return
     */
    public static boolean writeDataInServlet(String data, String fileName){
        boolean b = true;
        try {
            // 生成文件
            FileWriter dataFile = new FileWriter(fileName);
            dataFile.write(data);
            dataFile.flush();
            dataFile.close();
        }catch (IOException io){
            io.printStackTrace();
            b = false;
        }
        return b;
    }


    /**
     * 图片文件写入
     * @param base64Data 64base编译
     * @param fileCatalog 目录
     * @param pathFileName 文件名称
     * @return
     * @throws IOException
     */
    public static boolean writeBase64DataFile(String base64Data,String fileCatalog, String pathFileName) {
       boolean b = true;
       try {
           // 生成文件
           File imageFile = new File(pathFileName);
           File f = new File(fileCatalog);
           if (!f.exists()) {
               f.mkdir();
           }
           if (!imageFile.exists()) {
               imageFile.createNewFile();
           }
           OutputStream imageStream = new FileOutputStream(imageFile);
           byte[] imageByte = uploadImage(base64Data);
           imageStream.write(imageByte);
           imageStream.flush();
           imageStream.close();
       }catch (IOException io){
           b  = false;
       }
        return b;
    }

    //手机图片上传
    public static byte[] uploadImage(String base64Data){
        // 通过base64来转化图片
        BASE64Decoder decoder = new BASE64Decoder();
        // Base64解码
        byte[] imageByte = null;
        try {
            imageByte = decoder.decodeBuffer(base64Data);
            for (int i = 0; i < imageByte.length; ++i) {
                if (imageByte[i] < 0) {// 调整异常数据
                    imageByte[i] += 256;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageByte;
    }








}
