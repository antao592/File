package com.archie.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.archie.model.Picture;
@Component
public class PictureDao extends BaseDao{
    public boolean addPicture(Picture picture) throws Exception
    {
    	Picture bean = (Picture)getSqlMapClientTemplate().insert("insertPicture", picture);
        return bean != null ? true : false;
    }    
    public boolean deletePicture(String pname) throws Exception
    {
        int result = getSqlMapClientTemplate().delete("deletePicture", pname);
        return result > 0 ? true : false;
    }
    @SuppressWarnings("unchecked")
    public List getAllPictures() throws Exception
    {
        return getSqlMapClientTemplate().queryForList("findAllPicture");
    }    
}
