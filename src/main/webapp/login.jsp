<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆页面</title>
</head>
<body>
	用户名：<input name="username" type="text" />
	密码： <input name="password" type="password" />
	<button type="button" onclick="submit()">登陆</button>
</body>
<!-- jquery -->
<script type="text/javascript" src="<%=path %>/jquery/jquery-1.11.0.min.js"></script>
<script>
	function submit(){
		$.ajax({
	    	url: 'api/user/login',
			type: 'POST',
			dataType:'json',
			data:{
				"username":$('input[name="username"]').val(),
				"password":$('input[name="password"]').val(),
			},
			success:function(response){
				console.log(response);
			}
	    })
	}
</script>
</html>