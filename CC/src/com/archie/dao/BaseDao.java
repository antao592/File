package com.archie.dao;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import  org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ibatis.sqlmap.client.SqlMapClient;
public class BaseDao extends SqlMapClientDaoSupport
{
    @Resource(name = "sqlMapClientTemplate") //通过bean名称注入
    private SqlMapClientTemplate sqlMapClientTemplate ;
    @PostConstruct  //完成sqlMapClient初始化工作
    public void initSqlMapClientTemplate()
    {
        super.setSqlMapClientTemplate(sqlMapClientTemplate);
    }
}