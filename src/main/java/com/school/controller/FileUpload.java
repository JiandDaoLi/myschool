package com.school.controller;


import com.school.finals.FinalsString;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import sun.misc.BASE64Decoder;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Auther: XiTao
 * @Date: 2019/1/2
 * @Field:
 */
@RequestMapping("/file")
@RestController
public  class FileUpload {
    public static void main(String[] args) {
        String classPath = "";
        try {
             classPath = FileUpload.class.getClassLoader().getResource("static/image").getPath();
        }catch (NullPointerException e) {
            classPath = FileUpload.class.getClassLoader().getResource("static").getPath();
            classPath = classPath + "/image";
        }
        File file = new File(classPath+"/"+21231);
        try{
            if (!file.exists()){
                file.createNewFile();
            }

            file.createNewFile();
        }catch (Exception e){

        }


    }

    @RequestMapping("/upload")
    public String uploadFile(String base64Data) {
        //项目下的static地址
        String path = FinalsString.PROJECT_STATIC_RESOURCE_PATH;


        //获取服务器地址
        String url = FinalsString.PROJECT_URL;

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
        // 生成文件名
        String files = new SimpleDateFormat("yyyyMMddHHmmssSSS")
                .format(new Date())
                + (new Random().nextInt(9000) % (9000 - 1000 + 1) + 1000)
                + ".png";
        // 生成文件路径
        String filename = path +"/"+ files;


        try {
            // 生成文件
            File imageFile = new File(filename);
            File f = new File(path);
            if (!f.exists()) {
                f.mkdir();
            }
            if (!imageFile.exists()) {
                imageFile.createNewFile();
            }
            OutputStream imageStream = new FileOutputStream(imageFile);
            imageStream.write(imageByte);
            imageStream.flush();
            imageStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String classPath ="";
        try{
             classPath = FileUpload.class.getClassLoader().getResource("static/image").getPath();
        }catch (NullPointerException e){
            classPath = FileUpload.class.getClassLoader().getResource("static").getPath();
            classPath = classPath + "/image";
        }

        try {
            String fileNameClass = classPath+"/"+files;
            File f = new File(classPath);
            if (!f.exists()) {
                f.mkdir();
            }
            // 生成calss文件
            System.out.println(fileNameClass);
            File imageFileClass = new File(fileNameClass);
            if (!imageFileClass.exists()) {
                imageFileClass.createNewFile();
            }
            OutputStream imageStream = new FileOutputStream(imageFileClass);
            imageStream.write(imageByte);
            imageStream.flush();
            imageStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(url+"/"+files);
       return url + "/" + files;

    }

}
