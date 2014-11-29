package com.archie.task;

import java.io.File;
import java.io.IOException;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.archie.dao.PictureDao;
import com.archie.dao.VideoShowDao;

@Component
public class FileToStoreTask extends Thread {
	@Resource(name = "pictureDao") // 通过名称注入到bean里面 
    private PictureDao pictureDao;
	@Resource(name = "videoShowDao")
	private VideoShowDao videoShowDao;	
	private CommonsMultipartFile[] files;
	private String realfilepath;
	public FileToStoreTask()
	{
		
	}
	public FileToStoreTask(String realpicturepath,CommonsMultipartFile[] files) {
		this.realfilepath = realpicturepath;
		this.files = files;
	}
	
	
	public void run() {
		for(int i = 0;i<files.length;i++)
		{
    		String fileName = files[i].getOriginalFilename();
    		String fileType = fileName.substring(fileName.lastIndexOf("."));	
    		String fileAllName = Long.toString(new Date().getTime());
    		String realfilename = fileAllName + fileType;
    		String realfilepath1 = "";
    		if(fileType.equals(".png") || fileType.equals(".jpg"))
    		{
    			realfilepath1 = this.realfilepath + "/images/";
    			File file2 = new File("E:\\images\\", realfilename); // 新建一个文件
    			System.out.println(file2.getPath());
    			try 
    			{
    				System.out.println(files[i].getFileItem());
    				files[i].getFileItem().write(file2);
    			} 
    			catch (Exception e) 
    			{
    				e.printStackTrace();
    			}     			
    			// 将上传的文件写入新建的文件中
/*    			Picture picture = new Picture(realfilename,realfilepath1);
    	        try 
    	        {
    				pictureDao.addPicture(picture);
    			} 
    	        catch (Exception e) 
    	        {
    				e.printStackTrace();
    			}  */  			
    		}
    		else if(fileType.equals(".mp4") || fileType.equals(".avi"))
    		{
    			realfilepath1 = this.realfilepath + "\\videos\\";
/*    			Video video = new Video(fileAllName, "/videos", realfilename);
    			VideoShow videoShow = new VideoShow(realfilename, " ", " ");
    			try 
    			{
    				videoShowDao.addVideo(video, videoShow);
    			} 
    			catch (Exception e) 
    			{
    				e.printStackTrace();
    			} */   			
    		}
    		else
    		{
    			continue;
    		}

		}
	}
	public CommonsMultipartFile[] getFile() {
		return files;
	}

	public void setFile(CommonsMultipartFile[] files) {
		this.files = files;
	}

	public String getRealfilepath() {
		return realfilepath;
	}

	public void setRealfilepath(String realfilepath) {
		this.realfilepath = realfilepath;
	}

}
