<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  <title>JS联动下拉框</title>
  <meta name="GENERATOR" content="Microsoft FrontPage 4.0">
  <meta name="ProgId" content="FrontPage.Editor.Document">
  <meta name="Originator" content="Microsoft Visual Studio .NET 7.1">
 
	</head>
	
	 <script  language="javascript" src="./sanjia.js"></script>
	<body>
	
	<script src="./sanjia.js"></script>
	<p>js在<a href="http://www.21class.com/kehu/form/class_liandong_yao.js" target="_blank">这里</a> asp数据库调用在<a href="http://www.21class.com/kehu/form/htmlpage1.asp" target="_blank">这里</a></p>
  <form name="form1" method="post">
  	&nbsp;
  	<SELECT ID="s1" NAME="s1"  >
    <OPTION selected></OPTION>
  	</SELECT>
  	<SELECT ID="s2" NAME="s2"  >
    <OPTION selected></OPTION>
  	</SELECT>
  	<SELECT ID="s3" NAME="s3">
    <OPTION selected></OPTION>
  	</SELECT>
  	<br>
  	<br>
  	
  </form>
	</body>

	
	
<script language="javascript">
	//例子1-------------------------------------------------------------
	//数据源
  var array=new Array();
  array[0]=new Array("华南地区","根目录","华南地区"); //数据格式 ID，父级ID，名称
  array[1]=new Array("华北地区","根目录","华北地区");
  array[2]=new Array("上海","华南地区","上海");
  array[3]=new Array("广东","华南地区","广东");
  array[4]=new Array("徐家汇","上海","徐家汇");
  array[5]=new Array("普托","上海","普托");	
  array[6]=new Array("广州","广东","广州");
  array[7]=new Array("湛江","广东","湛江");
  //--------------------------------------------
  //这是调用代码
  var liandong=new CLASS_LIANDONG_YAO(array) //设置数据源
  liandong.firstSelectChange("根目录","s1"); //设置第一个选择框
  liandong.subSelectChange("s1","s2"); //设置子级选择框
  liandong.subSelectChange("s2","s3");
  
  
	//例子2-------------------------------------------------------------
	//数据源	
/*
  var array2=new Array();//数据格式 ID，父级ID，名称
  array2[0]=new Array("测试测试","根目录","测试测试"); 
  array2[1]=new Array("华北地区","根目录","华北地区");
  array2[2]=new Array("上海","测试测试","上海");
  array2[3]=new Array("广东","测试测试","广东");
  array2[4]=new Array("徐家汇","上海","徐家汇");
  array2[5]=new Array("普托","上海","普托");	
  array2[6]=new Array("广州","广东","广州");
  array2[7]=new Array("湛江","广东","湛江");
  array2[8]=new Array("不知道","湛江","不知道");
  array2[9]=new Array("5555","湛江","555");
  array2[10]=new Array("++++","不知道","++++");
  array2[11]=new Array("111","徐家汇","111");
  array2[12]=new Array("222","111","222");
  array2[13]=new Array("333","222","333");
  //--------------------------------------------
  //这是调用代码
  //设置数据源
  var liandong2=new CLASS_LIANDONG_YAO(array2);
  //设置第一个选择框
  liandong2.firstSelectChange("根目录","x1");
  //设置子选择框
  liandong2.subSelectChange("x1","x2")
  liandong2.subSelectChange("x2","x3")
  liandong2.subSelectChange("x3","x4")
  liandong2.subSelectChange("x4","x5")
  */
	</script>
</html>
