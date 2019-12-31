package com.workman.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.UUID;

/**
 * @Description TODO
 * @Auth 向问天
 * @Date 2019/12/31 17:59
 * @Version 1.0
 */
@Slf4j
@Controller
public class UploadController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        log.info("invoke IndexController method index");
        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletRequest request, MultipartFile file) {
        log.info("into upload method");
        try {
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            log.info("uploadDir:{}", uploadDir);
            //如果目录不在就创建一个
            File dir = new File(uploadDir);
            log.info("dir:" + JSON.toJSONString(dir));
            if (!dir.exists()) {
                dir.mkdir();
            }
            //上传文件名
            String fileName = file.getOriginalFilename();
            //服务器端保存的文件对象
            File serverFile = new File(uploadDir + fileName);
            //将上传的文件写入服务器端文件内
            file.transferTo(serverFile);
        } catch (Exception e) {
            log.error("上传失败", e);
            return "上传失败";
        }
        return "上传成功";
    }
    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    @ResponseBody
    public String uploads(HttpServletRequest request,MultipartFile[] file){
        try {
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            log.info("uploadDir:{}", uploadDir);
            //如果目录不在就创建一个
            File dir = new File(uploadDir);
            log.info("dir:" + JSON.toJSONString(dir));
            if (!dir.exists()) {
                dir.mkdir();
            }
            //上传文件名
            //String fileName = file.getOriginalFilename();
            //服务器端保存的文件对象
            //File serverFile = new File(uploadDir + fileName);
            //将上传的文件写入服务器端文件内
            //file.transferTo(serverFile);
            for(int i=0;i<file.length;i++){
                if(file[i] != null){
                    executeUpload(uploadDir,file[i]);
                }
            }
        } catch (Exception e) {
            log.error("上传失败", e);
            return "上传失败";
        }
        return "上传成功";
    }

    private void executeUpload(String uploadDir,MultipartFile file) throws Exception{
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID()+suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir+filename);
        //将上传的文件写入服务器端文件内
        file.transferTo(serverFile);
    }

}
