<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<script type="text/javascript" src="./resources/jquery.js"></script>
	<script type="text/javascript" src="./resources/json2.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
// 			var addPersonCmdTest = {};  
// 			var tmpLista= new Array();
// 			tmpLista.push({name:"xx222",now:"2017-04-15 12:23:12"});
// 			tmpLista.push({name:"xx333",now:"2017-04-15 12:23:12"});
			
// 			addPersonCmdTest.tmpList = tmpLista;
// 			addPersonCmdTest.account="nihao";
// 			addPersonCmdTest.name="name中文";
// 			addPersonCmdTest.time="2017-04-15 12:23:12";
// 			var list = new Array();
// 			list.push("str1");list.push("str2");list.push("str3");
// 			addPersonCmdTest.list = list;
			
// 			$.ajax({
// 				url:"test",
// 				type:"post",
// 				data:JSON.stringify(addPersonCmdTest),
// 				dataType:"json",
// 				contentType:"application/json;charset=utf-8",
// 				success:function(data){
// 					console.log(data);
// 				},error:function(data){
// 				}
// 			});
			//====2=
			var alist = new Array();  
			alist.push({name: "李四",now:"2017-04-18 12:22:23"});   
			alist.push({name: "张三",now:"2017-04-17 12:22:22"});   
			var cmd = {};  
			cmd.account = "李刚";  
			cmd.name = "888";  
			cmd.time="2017-04-15 12:23:12";
			cmd.tmpList = alist;  
			var blist = new Array();
			blist.push("str1");blist.push("str2");blist.push("str3");
			cmd.list = blist;
			
			$.ajax({  
			    type: "POST",  
			    url: "test",  
			    data: JSON.stringify(cmd),//将对象序列化成JSON字符串  
			    dataType:"json",  
			    contentType : 'application/json;charset=utf-8', //设置请求头信息  
			    success: function(data){  
			       console.log(data); 
			    },  
			    error: function(res){  
			       
			    }  
			});
		});
	
	</script>
</head>
<body>
<h2>Hello World!</h2>
<form action="login" method="POST">
	登录类型<input name="login_type" value=""/><br/>
	
	account<input name="account" value=""/><br/>
	pwd<input name="pwd" value=""/><br/>
	name<input name="name" value=""/><br/>
	<input type="submit" value=""提交">
	
</form>
</body>
</html>
