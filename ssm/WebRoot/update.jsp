<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <form action="${pageContext.servletContext.contextPath}/doupdate" method="post" >
         <!-- name里面的值，不能随便写，它是属性里面的值 ，名字要对应好-->
         <!-- 因为更新的时候需要根据id更新，因为id也要传递过来，可以放在隐藏域里面 -->
         <input type="hidden" name="id" value="${person.id}"/>
        <p>姓名：<input type="text" name="name" value="${person.name}"/></p>
        <p>年龄：<input type="text" name="age" value="${person.age}"/></p>
        <p>地址：<input type="text" name="address" value="${person.address }"/></p>
        <!-- 添加的时候映射的是id因此这里取值，也要是id -->
        <p>部门：<select name="dept.id">
                    <option value="-1">请选择</option>
                       <c:forEach var="d" items="${depts}">
                           <option value="${d.id }" <c:if test="${d.id==person.dept.id}">selected="selected"</c:if> >${d.deptname }</option>
                       </c:forEach>
                </select>
                <input type="submit" value="修改" /> 
   </form>
</body>
</html>