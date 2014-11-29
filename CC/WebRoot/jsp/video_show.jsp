<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                        + request.getServerName() + ":" + request.getServerPort()
                        + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <base href=<%=basePath%> />
  <title>幸福小窝</title>
  
  <script language="javascript" src="js/jquery-1.7.1.js" type="text/javascript"></script>
  <script language="javascript" src="js/ajaxfileupload.js" type="text/javascript"></script>
  <link type="text/css" rel="stylesheet" href="css/styles.css" />
 
</head>

<body class="cms-home">
<h2><%=request.getParameter("vtext")%></h2>
<video id="mv" src=<%=request.getParameter("vpath") %><%=request.getParameter("vname") %> width='500' height='500' controls='controls'></video><br/>
<input id="bn" type="button" value="播放" /><span id="detail"></span>分 
 <script type="text/javascript">
  var bn=document.getElementById("bn");
  var mv=document.getElementById("mv");
  var detail=document.getElementById("detail");
  mv.ontimeupdate=function()
  {
  	detail.innerHTML = Math.round(mv.currentTime / 60) + "/" + Math.round(mv.duration / 60);
  };
  bn.onclick = function()
  {
  	if(mv.paused)
  	{
  		mv.play();
  		bn.value = "暂停";
  	}
  	else
  	{
  		mv.pause();
  		bn.value = "播放";
  	}  	
  }
  mv.onclick = function()
  {
  	if(mv.paused)
  	{
  		bn.value = "暂停";
  	}
  	else
  	{
  		bn.value = "播放";
  	}
  }
  </script>
</body>
</html>
