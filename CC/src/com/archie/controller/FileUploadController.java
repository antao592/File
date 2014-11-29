package com.archie.controller;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.archie.dao.PictureDao;
import com.archie.dao.VideoShowDao;
import com.archie.model.Picture;
import com.archie.model.Video;
import com.archie.model.VideoShow;



@Controller

public class FileUploadController 
{
	
	@Resource(name = "pictureDao") // 通过名称注入到bean里面 
    private PictureDao pictureDao;
	@Resource(name = "videoShowDao")
	private VideoShowDao videoShowDao;
	@RequestMapping("/upload.do")
    public void handleUploadData(HttpServletRequest request, HttpServletResponse response, @RequestParam("images") CommonsMultipartFile[] files) throws Exception
    {
    	response.setContentType("text/html");
    	String retxt = "";  
    	
    	for(int i = 0;i<files.length;i++)
    	{
    		String fileName = files[i].getOriginalFilename();
    		String fileType = fileName.substring(fileName.lastIndexOf("."));
    		String fileAllName = Long.toString(new Date().getTime());
    		String realfilename = fileAllName + fileType;
    		//String contextpath = request.getContextPath();
    		//String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextpath + "/";
    		//String fileAllPath = basePath + "images/";

    	    if(fileType.equals(".png") || fileType.equals(".jpg"))
            {
    	    	String realfilepath = request.getSession().getServletContext().getRealPath("/images/");  //获取本地存储路径    	    	
            	System.out.println("fileType="+fileType);
            	File file2 = new File(realfilepath, realfilename); //新建一个文件
            	System.out.println(file2.getPath());
                try
                {
                	System.out.println(files[i].getFileItem());
                    files[i].getFileItem().write(file2); //将上传的文件写入新建的文件中
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                //文件上传成功，将上传文件的名字，目录存入数据库
                Picture picture = new Picture(realfilename,"images/");
                pictureDao.addPicture(picture);
                retxt = "{status:'SUCC'}";
            }
            else if(fileType.equals(".mp4") || fileType.equals(".avi"))
            {
    	    	String realfilepath = request.getSession().getServletContext().getRealPath("/videos/");  //获取本地存储路径    	    	
            	System.out.println("fileType="+fileType);
            	File file2 = new File(realfilepath, realfilename); //新建一个文件
                try
                {
                    files[i].getFileItem().write(file2); //将上传的文件写入新建的文件中
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                //文件上传成功，将上传文件的名字，目录存入数据库
                Video video = new Video(realfilename, "videos/", fileAllName);
                VideoShow videoShow = new VideoShow(fileAllName, " ", " ");
                videoShowDao.addVideo(video, videoShow);
                retxt = "{status:'SUCC'}";
            }
            else
            {
            	//pictureList.add(fileAllPath  + fileAllName + fileType);
            	retxt = "{status:'ERROR'}";
            	break;
            }
            
    	}
    	response.getWriter().print(retxt);
    }
}

