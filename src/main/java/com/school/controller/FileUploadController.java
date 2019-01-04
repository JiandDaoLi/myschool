package com.school.controller;


import com.school.finals.FinalsString;
import com.school.util.StringUitl;
import com.school.util.UpLoadUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: XiTao
 * @Date: 2019/1/2
 * @Field:手机相册上传到服务器
 */
@RequestMapping("/file")
@RestController
public class FileUploadController {

    @RequestMapping("/upload")
    public String uploadFile(String base64Data) {
        //项目下的static地址
        String path = FinalsString.PROJECT_STATIC_RESOURCE_PATH_IMAGE;
        //获取服务器地址
        String url = FinalsString.PROJECT_URL;
        //生成文件名称
        String files = StringUitl.createStringRandomName();
        // 生成文件路径
        String filename = path + "/" + files;
        //写入文件
        boolean b = UpLoadUtil.writeBase64DataFile(base64Data, path, filename);
        String classPath = "";
        try {
            classPath = FileUploadController.class.getClassLoader().getResource("static/image").getPath();
        } catch (NullPointerException e) {
            classPath = FileUploadController.class.getClassLoader().getResource("static").getPath();
            classPath = classPath + "/image";
        }
        //class文件名称
        String fileNameClass = classPath + "/" + files;
        //写入到classpath下
        boolean bo = UpLoadUtil.writeBase64DataFile(base64Data, classPath, fileNameClass);
        return url + "/" + files;

    }

}
