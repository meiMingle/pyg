package com.pinyougou.shop.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import util.FastDFSClient;

/**
 * controller
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/file")
public class UploadController {

    @Value("${FILE_SEVER_URL}")
    private String FILE_SEVER_URL;

    /**
     * 返回全部列表
     *
     * @return
     */
    @RequestMapping("/upload")
    public Result upload(MultipartFile file) {//此处‘file’必须与前端传入变量名一致
        //获取文件后缀名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);//注意：这里是lastIndexOf而不是indexOf

        try {


            //上传文件到dfs服务器

            FastDFSClient fastDFSClient = new FastDFSClient("classpath:\\config\\fdfs_client.conf");
            byte[] fileCount = file.getBytes();
            String dfsPathOfFile = fastDFSClient.uploadFile(fileCount, extName);

            //成功返回完整路径
            return new Result(true, FILE_SEVER_URL + dfsPathOfFile);
        } catch (Exception e) {
            e.printStackTrace();
            //失败返回错误信息
            return new Result(false, "上传失败");
        }


    }


}
