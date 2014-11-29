package com.archie.model;

public class Video {
	private String vname;
	private String vpath;
	private String vsource;
	public Video()    
	{    } 

	public Video(String vname,String vpath,String vsource)
	{
	    this.vname = vname;
	    this.vpath = vpath;
	    this.vsource = vsource;
	}	
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVpath() {
		return vpath;
	}
	public void setVpath(String vpath) {
		this.vpath = vpath;
	}

	public void setVsource(String vsource) {
		this.vsource = vsource;
	}

	public String getVsource() {
		return vsource;
	}
}
