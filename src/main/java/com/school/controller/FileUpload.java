package com.school.controller;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.jni.Global;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

/**
 * @Auther: XiTao
 * @Date: 2019/1/2
 * @Field:
 */
@RequestMapping("/file")
@RestController
public class FileUpload {


    @RequestMapping("/upload")
    public ModelAndView uploadFile(String base64Data) {
        ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView());
        //项目下的static地址
        String path = FileUpload.class.getClassLoader().getResource("static/").getPath().replaceFirst("/", "");
        //获取服务器地址
        String url = null;
        try {
            String dataPath = FileUpload.class.getClassLoader().getResource("service-url.properties").getPath();
            Properties pro = new Properties();
            FileInputStream in = new FileInputStream(dataPath);
            url = pro.getProperty("service");
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        String filename = path + files;
        try {
            // 生成文件
            File imageFile = new File(filename);
            imageFile.createNewFile();
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
        modelAndView.addObject("url", url+path + files);
        return modelAndView;
    }

}
