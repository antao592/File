package com.archie.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.archie.model.Picture;
import com.archie.model.Video;
@Component  //将PictureDao类注入到bean里面
public class VideoDao extends BaseDao{
    public boolean addVideo(Video video) throws Exception
    {
    	Video bean = (Video)getSqlMapClientTemplate().insert("insertVideo", video);
        return bean != null ? true : false;
    }    
    public boolean deleteVideo(String vname) throws Exception
    {
        int result = getSqlMapClientTemplate().delete("deleteVideo", vname);
        return result > 0 ? true : false;
    }
    @SuppressWarnings("unchecked")
    public List getAllVideos() throws Exception
    {
        return getSqlMapClientTemplate().queryForList("findAllVideo");
    }    
}
