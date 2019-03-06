<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ajaxtest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   
  <script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
      $(function(){
      
      
      //按钮click获取列表对象
      $("#btn2").click(function(){
            $.ajax({
                url:"showlist",
                type:"post",
                dataType:"json",
                success:function(result){
                    //alert(result);
                    var message="";
                    
                   for(var i=0;i<result.length;i++ ){
                       message+="<p>"+result[i].id+":"+result[i].name+":"+result[i].age+"</p>";
                   }
                   $("#obj").html(message);
                }
            });
      });
      
      //////////////////////////////////////////
      //按钮click获取对象
      $("#btn1").click(function(){
            $.ajax({
                url:"showperson",
                type:"post",
                dataType:"json",
                success:function(result){
                   // alert(result);
                    //
                   var obj=$("#obj").html(result.id+":"+result.name+":"+result.age+":"+result.birth+":"+result.birthday);
                }
            });
      });
 
      //////////////////////////////////////////
          //blur
          $("#name").blur(function(){
             var name=$("#name").val();
             if(name==""){
                 $("#msg").html("用户名不能为空！");
                 return;
             }
             //ajax
             $.post("valid","name="+name,function(result){
                    if(result=="ok"){
                         $("#msg").html("此用户可以使用！");
                    }else{
                         $("#msg").html("此用户不能使用！");
                    }
             });//post
          });//blur
      });//func
  </script>
  </head>
  <body>
   <form>
        用户名：<input type="text" name="name" id="name"><span id="msg"></span>
            <input type="button" id="btn1" value="获取一个对象"/>
            <input type="button" id="btn2" value="获取对象列表"/>
        
   </form>
   <div id="obj"></div>
  </body>
</html>
