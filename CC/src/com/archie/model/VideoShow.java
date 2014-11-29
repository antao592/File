package com.archie.model;

public class VideoShow {
	private String vsource;
	private String vtext;
	private String vpicture;
	public VideoShow()    
	{    
		
	} 

	public VideoShow(String vsource,String vtext,String vpicture)
	{
	    this.vsource = vsource;
	    this.vtext = vtext;
	    this.vpicture = vpicture;
	}

	public String getVsource() {
		return vsource;
	}

	public void setVsource(String vsource) {
		this.vsource = vsource;
	}

	public String getVtext() {
		return vtext;
	}

	public void setVtext(String vtext) {
		this.vtext = vtext;
	}

	public String getVpicture() {
		return vpicture;
	}

	public void setVpicture(String vpicture) {
		this.vpicture = vpicture;
	}	

}
