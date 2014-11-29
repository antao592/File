package com.archie.dao;
import java.util.List;

import com.archie.model.User;

import org.springframework.stereotype.Component;
@Component  //��UserDao��ע�뵽bean����
public class UserDao extends BaseDao
{
    public boolean addUser(User user) throws Exception
    {
        User bean = (User)getSqlMapClientTemplate().insert("insertUser", user);
        return bean != null ? true : false;
    }    
    public boolean deleteUser(int id) throws Exception
    {
        int result = getSqlMapClientTemplate().delete("deleteUser", id);
        return result > 0 ? true : false;
    }    
    public User getUserById(int id) throws Exception
    {
        return (User)getSqlMapClientTemplate().queryForObject("findUserByID", id);
    }
    @SuppressWarnings("unchecked")
    public List getAllUsers() throws Exception
    {
        return getSqlMapClientTemplate().queryForList("findAllUser");
    }    
    public boolean updateUser(User user) throws Exception
    {
        int result = getSqlMapClientTemplate().update("updateUser", user);
        return result > 0 ? true : false;
    }    
    public User getUserByNameAndPassword(User user) throws Exception
    {
        return (User)getSqlMapClientTemplate().queryForObject("findUserByNameAndPassword", user);
    }    
    public int getTotalCount() throws Exception
    {
        return (Integer)getSqlMapClientTemplate().queryForObject("getTotalCount");
    }
    @SuppressWarnings("unchecked")
    public List getUsersByLike(User user) throws Exception
    {
        return getSqlMapClientTemplate().queryForList("searchUsers", user);
    }
    public int deleteUserByLike(User user) throws Exception
    {
        int result =  getSqlMapClientTemplate().delete("deleteUserByLike", user);
        if (result > 0)
        {
            System.out.println(" ģ��ɾ���ɹ���");
        }
        else
        {
            System.out.println(" û��ƥ��ļ�¼1");
        }
        return result;
    }
}