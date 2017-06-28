<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상세글</title>

</head>
<body>
<!-- 본문 시작 -->         

<div>
    <table>
    <tr>
        <th style="width: 50px;">제목</th>
        <th style="text-align: left;color: #555;">${read.postTitle }</th>
        <th style="width: 50px;">작성일</th>
        <th style="width: 130px;color: #555;">${read.postDateUp }</th>
    </tr>  
    </table>
   
    <div>
        <p>작성자 : ${read.user.userId }</p>
        <p>${read.postContent }</p>
    </div>
 
<div>
<c:forEach var="post" items="${comment }">  
<p>댓글: ${post.commentContent }</p>
</c:forEach>
</div>
</div>
<!--  본문 끝 -->

</body>
</html>