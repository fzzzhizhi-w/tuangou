package com.controller;

import com.annotation.IgnoreAuth;
import com.utils.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${server.port:8080}")
    private String port;

    @IgnoreAuth
    @RequestMapping("/upload")
    public R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return R.error("上传文件不能为空");
        }
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename != null && originalFilename.contains(".")
            ? originalFilename.substring(originalFilename.lastIndexOf("."))
            : "";
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
            + (int)(Math.random() * 900 + 100) + suffix;

        String uploadPath = System.getProperty("user.dir") + "/src/main/resources/static/upload/";
        File dir = new File(uploadPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File dest = new File(uploadPath + newFileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            return R.error("文件上传失败：" + e.getMessage());
        }

        String scheme = request.getScheme();
        String serverName = request.getServerName();
        String fileUrl = scheme + "://" + serverName + ":" + port + "/static/upload/" + newFileName;
        return R.ok().put("src", fileUrl).put("url", fileUrl);
    }
}
