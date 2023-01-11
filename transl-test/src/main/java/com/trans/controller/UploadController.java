package com.trans.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Author: ZouJiaJun
 * @Title: UploadController
 * @Package: com.trans.controller
 * @Description:
 * @Date: 2023/1/11 - 17:08
 */
@Api(tags = "测试文件上传")
@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {

    @Value("${spring.servlet.multipart.location}")
    private String fileTempPath;

    @PostMapping("/local")
    public Dict loacl(@RequestParam("file")MultipartFile file){
        if(file == null){
            return Dict.create().set("code",500).set("message","请上传文件");
        }
        String fileName = file.getOriginalFilename();
        log.info("文件名：{}",fileName);
        String rawFileName = StrUtil.subBefore(fileName, ".", true);
        log.info("原始文件名rawFileName:{}",rawFileName);
        String fileType = StrUtil.subAfter(fileName, ".", true);
        log.info("fileType:{}",fileType);
        String localFilePath = StrUtil.appendIfMissing(fileTempPath, "/") + rawFileName + "-" + DateUtil.current() + "." + fileType;
        File localFile = new File(localFilePath);
        if(!localFile.getParentFile().exists()){
            localFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(localFile);
        }catch (IOException e){
            log.error("【文件上传至本地】失败，绝对路径：{}", localFilePath);
            return Dict.create().set("code", 500).set("message", "文件上传失败");
        }
        log.info("【文件上传至本地】绝对路径：{}", localFilePath);
        return Dict.create().set("code", 200).set("message", "上传成功").set("data", Dict.create().set("fileName", fileName).set("filePath", localFilePath));

    }
}