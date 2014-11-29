package com.archie.dao;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import  org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ibatis.sqlmap.client.SqlMapClient;
public class BaseDao extends SqlMapClientDaoSupport
{
    @Resource(name = "sqlMapClientTemplate") //ͨ��bean����ע��
    private SqlMapClientTemplate sqlMapClientTemplate ;
    @PostConstruct  //���sqlMapClient��ʼ������
    public void initSqlMapClientTemplate()
    {
        super.setSqlMapClientTemplate(sqlMapClientTemplate);
    }
}