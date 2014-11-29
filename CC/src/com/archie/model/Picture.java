package com.archie.model;

public class Picture {
private String pname;
private String ppath;
public Picture()    
{    } 

public Picture(String pname,String ppath)
{
    this.pname = pname;
    this.ppath = ppath;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPpath() {
	return ppath;
}
public void setPpath(String ppath) {
	this.ppath = ppath;
}
}
