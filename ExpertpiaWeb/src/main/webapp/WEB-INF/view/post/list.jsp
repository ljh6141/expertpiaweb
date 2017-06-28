<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jstl forEach  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 날짜 fotmat -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
    <table>
    <c:forEach var="post" items="${list}" varStatus="status"> 
    <tr>
        <th>번호</th>
        <th>${post.postId }</th>
        <th>제목</th>
        <td><a href="../post/read?id=${post.postId }">${post.postTitle }</a>
        <th>작성일</th>
        <th>${post.postDateUp }</th>
    </tr>
    </c:forEach>
<%--     <c:forEach var="post1" items="${comment}"> --%>
<!-- 	<span>연관글:</span> -->
<!-- 	<span>댓글:</span> -->
<%--     </c:forEach> --%>
    </table>
</div>

</body>
</html>