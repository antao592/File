package com.archie.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.archie.model.Video;
import com.archie.model.VideoShow;
@Component  
public class VideoShowDao extends BaseDao{
    public boolean addVideo(Video video,VideoShow videoShow) throws Exception
    {

    	getSqlMapClientTemplate().insert("insertVideo", video);
    	getSqlMapClientTemplate().insert("insertVideoShow", videoShow);

        return true;
    }    
    public boolean deleteVideo(String vname) throws Exception
    {
        int result = getSqlMapClientTemplate().delete("deleteVideoShow", vname);
        return result > 0 ? true : false;
    }
    @SuppressWarnings("unchecked")
    public Map<String,List> getAllVideoShow() throws Exception
    {
    	//Map aaa = new HashMap();
    	//System.out.println("111111="+getSqlMapClientTemplate().queryForMap("findAllVideoShow",null,"vname"));
        return getSqlMapClientTemplate().queryForMap("findAllVideoShow",null,"vsource");
    }    
}
