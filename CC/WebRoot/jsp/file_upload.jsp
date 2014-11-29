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
  <script>
function ajaxFileUpload()
{
    jQuery.ajaxFileUpload(
    {
        url : 'upload.do',
        secureuri : false,
        fileElementId : 'images',
        dataType : 'json',
        success : function (data, status)
        {

        	
            var data = eval('(' + data + ')');
            if(data.status == "SUCC")
            {
            	
            	jQuery('#result').html('上传成功');
            }
            if(data.status == "ERROR")
            {
            	alert("上传文件必须是图片或视频");
            	jQuery('#result').html('上传失败');
            }

        },
        error : function (data, status, e)
        {
            jQuery('#result').html('上传失败');
        }
    }
    );
};  
  </script><!--
  <script>
  var reader = null;
  if(FileReader)
  {
  	reader = new FileReader();
  }
  else
  {
  	alert("浏览器不支持FilerReader");
  }
  var readBinary = function()
  {
  	 var imageEle = document.getElementById("images");
  	 var fileList = imageEle.files;
  	 for(var i=0;i<fileList.length;i++)
  	 {
  	 	reader.readAsBinaryString(fileList[i]);
  	 	var pro = document.createElement("progress");
  	 	pro.value = 0;
	  	pro.max = fileList[i].size;
	  	reader.onprogress = function(evt)
	  	{
	  		pro.value = evt.loaded;
	  	}
	  	var txt1 = fileList[i].name;
	  	var txt2 = "<br />"
	  	jQuery('#result').append(pro,txt1,txt2);  	 	
  	 }
  }
  </script>
--></head>

<body class="cms-home">
  <form name="form_uploadImg" action="" method="post" enctype="multipart/form-data" id="form_uploadImg">
    文件：<input id="images" name="images" type = "file" multiple />
  </form>
  <input type="button" id="buttonUpload" onclick="ajaxFileUpload();" value="上传" />  
  <div id=result></div><br /><br />   
  <a href="jsp/file_show.jsp">进入我的小窝吧...</a>
</body>
</html>
