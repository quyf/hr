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
			var addPersonInfoCmd={};
			addPersonInfoCmd.personId=25;
			var personBaseInfos ={};
			personBaseInfos.afterTaxSalary=2;
			personBaseInfos.babys=1;
			personBaseInfos.birthday="2017-05-30";
			personBaseInfos.dispute=0;
			personBaseInfos.jiguan="江西赣州";
			personBaseInfos.marrayFlag=1;
			personBaseInfos.minzu="彝族";
			personBaseInfos.name="张苏纳";
			personBaseInfos.nowAddress="sadda";
			personBaseInfos.peiouName="dsa";
			personBaseInfos.post="高级Java开发工程师（平台）";
			personBaseInfos.preTaxSalary=3;
			personBaseInfos.promisee="张苏纳";
			personBaseInfos.sex="男";
			personBaseInfos.workCompany="asd";
			personBaseInfos.workTime="2017-05-04";
			
			var educationInfos = new Array();
			
			educationInfos.push({beginDate: "2017-04-18",endDate:"2017-04-18",school:"nchu",major:"network",xueli:"benke", way:"全你在",num:1});   
			educationInfos.push({beginDate: "2017-04-18",endDate:"2017-04-18",school:"nchu2",major:"network2",xueli:"benke", way:"全你在",num:2});
			
			var workExperienceInfos = new Array();  
			workExperienceInfos.push({beginDate: "2017-04-18",endDate:"2017-04-18",company:"21cn",title:"network",reson:"想走了", salary:"11111",num:1});   
			workExperienceInfos.push({beginDate: "2017-04-18",endDate:"2017-04-18",company:"QQ",title:"network2",reson:"炒老板", salary:"2222",num:2}); 
			
			var referenceInfo ={};
			referenceInfo.hrName="zzz"; // 证明人姓名
			referenceInfo.hrComTitle="hr"; // 单位名称及职务
			referenceInfo.hrLink="12346"; // 联系方式
			referenceInfo.hrEmail="333@qq.com"; // 邮箱
			referenceInfo.leaderName="111"; // 证明人姓名
			referenceInfo.ldComTitle="zjl"; // 单位名称及职务
			referenceInfo.ldLink="13966"; // 联系方式
			referenceInfo.ldEmail="1258@qq.com"; // 邮箱
			referenceInfo.hasYy=1; // 是否有用友成员公司及本公司亲属/朋友信息，0:无 1:有
			referenceInfo.yyName="zyh"; // 员工姓名
			referenceInfo.yygx="py"; // 与员工的关系
			referenceInfo.yyTitle="html"; // 员工职务
			referenceInfo.yyEmail="zaa@yonyou.com"; // 员工邮箱
			
			addPersonInfoCmd.personBaseInfos=personBaseInfos;
			addPersonInfoCmd.educationInfos=educationInfos;
			addPersonInfoCmd.workExperienceInfos=workExperienceInfos;
			addPersonInfoCmd.referenceInfo=referenceInfo;
			
			console.log(addPersonInfoCmd);
			$.ajax({  
				
			    type: "POST",  
			    url: "person/info",  
			    data: JSON.stringify(addPersonInfoCmd),//将对象序列化成JSON字符串  
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
