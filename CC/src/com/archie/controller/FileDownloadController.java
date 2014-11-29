package com.archie.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.archie.dao.PictureDao;
import com.archie.dao.VideoDao;
import com.archie.dao.VideoShowDao;


@Controller
@RequestMapping("/download.do")
public class FileDownloadController {
    @Resource(name = "pictureDao") // 通过名称注入到bean里面 
    private PictureDao pictureDao; 
    @Resource(name = "videoShowDao") // 通过名称注入到bean里面
    private VideoShowDao videoShowDao;
	
	@RequestMapping(params="method=picture")
    @ResponseBody
    public List handleDownloadPicture() throws Exception
    {
    	List pictures = pictureDao.getAllPictures();
    	return pictures;
    }
	@RequestMapping(params="method=video")
    @ResponseBody
    public Map<String,List> handleDownloadVideo() throws Exception
    {
    	Map<String,List> videoShow = videoShowDao.getAllVideoShow();
    	System.out.println("videoShow="+videoShow);
    	return videoShow;
    }
}
