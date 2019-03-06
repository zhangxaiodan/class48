<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
        //页面跳转
       function topage(index){
             alert(index);
             //给隐藏域赋值
             document.getElementById("index").value=index;
             //表单提交
             document.forms[0].submit();
       }
  </script>
  </head>
  <body>
  
    <form action="${pageContext.servletContext.contextPath}/show" method="post">
        
                员工姓名：<input type="text" name="name" id="name" value="${param.name }"/>
                部门名称：<select name="deptno">
                    <option value="-1">全部</option>
                    <c:forEach var="d" items="${list}">
                           <option value="${d.id }"<c:if test="${d.id==param.deptno}">selected="selected"</c:if>>${d.deptname }</option>
                    </c:forEach>
                </select>
           <!--上面的脚本是赋值到隐藏域，提交的时候，把index一起传递过去，因此加到这里 -->
        <input type="hidden"  name="index" value="1" id="index"/>
          <input type="submit" value="查询"/>
    </form>
    <table>
       <tr>
          <td>员工编号</td>
          <td>员工姓名</td>
          <td>员工年龄</td>
          <td>员工地址</td>
          <td>部门编号</td>
          <td>部门名称</td>
          <td>操作</td>
       </tr>
     <c:forEach var="p" items="${page.list }">
        <tr>
          <td>${p.id }</td>
          <td>${p.name }</td>
          <td>${p.age }</td>
          <td>${p.address }</td>
          <td>${p.dept.id }</td>
          <td>${p.dept.deptname }</td>
          
          <td><a href="${pageContext.servletContext.contextPath}/toupdate/${p.id}">更新</a></td>
          <td><a href="${pageContext.servletContext.contextPath}/del/?id=${p.id}" onclick="return confirm('确定删除吗')">删除</a></td>
       </tr>
    </c:forEach>  
    </table>
    <div>
        <c:if test="${page.pageIndex>1}">
            <a href="javascript:topage(1)">首页</a>
            <a href="javascript:topage(${page.pageIndex-1})">上一页</a>
        </c:if>
        
        <c:if test="${page.pageIndex<page.totalPage}">
            <a href="javascript:topage(${page.pageIndex+1})">下一页</a>
            <a href="javascript:topage(${page.totalPage})">末页</a>
        </c:if>
    </div> 
    
    <!-- 到控制器中去处理，然后到添加页面，然后跳转到列表页面（重新显示列表）-->
    <a href="${pageContext.servletContext.contextPath}/toadd">添加</a>
    
    
  </body>
</html>
