<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>글 상세</title>
</head>
<body>

<h1>게시글 상세</h1>
<hr>
<form action="updateBoard" method="post">
<input name="seq" type="hidden" value="${board.seq}" />

<table border="1">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input type="text" name="title" value="${board.title}" /></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left">${board.writer}</td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10">${board.content}</textarea></td>
	</tr>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td align="left"><fmt:formatDate value="${board.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
	</tr>	
	
	<tr>
		<td bgcolor="orange">조회수</td>
		<td align="left">${board.cnt}</td>
	</tr>
	<tr>
	<td colspan="2" align="center">
		<input type="submit" value="글 수정" /></td>
	</tr>
	

</table>
</form>
<hr>
<a href="insertBoardView">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard?seq=${board.seq}">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList">글목록</a>

</body>
</html>