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
  <script type="text/javascript" src="js/file_show.js"></script>
  <link type="text/css" rel="stylesheet" href="css/styles.css" />
</head>

<body class="cms-home">
  <button id="show" type="button">相册</button>
  <div class="indent-col-main" style="display:none;">
    <div class="block-slider">
        <ul id="slider_list" class="products-grid"></ul>
    </div>
    <div id="left_but" class="box-left"></div>
    <div id="right_but" class="box-right"></div>
  </div>
  <button id="show1" type="button">视频</button>
  <div class="videos" style="display:none;">
  <ul id="video_list" class="video_list"></ul>
  </div>
</body>
</html>
