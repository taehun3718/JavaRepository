<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일 업로드 테스트</title>
</head>
<body>
	<h2>파일 리스트</h2>
	<table>
		<tr>
			<th>Id</th>
			<th>파일1</th>
			<th>파일2</th>
			<th>다운로드1</th>
			<th>다운로드2</th>
		</tr>
		<c:forEach var="board" items="${boardList }">
			<tr class="boardList">
				<td>${board.id }</td>
				<td>${board.realfileNameOne}</td>
				<td>${board.realfileNameTwo}</td>
				<td><a href="<c:url value="/board/download/${board.id}/0"/>">다운1</a>
				<td><a href="<c:url value="/board/download/${board.id}/1"/>">다운2</a>
				<td>
					<img src="<c:url value="/board/download/${board.id}/0"/>" width="50" height="20"/>
					<img src="<c:url value="/board/download/${board.id}/1"/>" width="50" height="20"/>
				</td>
			</tr>
		</c:forEach>
	</table>
	<h2>파일 업로드</h2>
	<form id="uploadForm" name="uploadForm" method="POST"
		enctype="multipart/form-data" action="<c:url value="/doWrite"/>">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" id="subject" name="subject" /></td>
			</tr>

			<tr>
				<td>내용</td>
				<td><textarea name="content" id="content"></textarea></td>
			</tr>
		</table>

		<input type="file" id="fileOne" name="fileOne" />/ <input type="file"
			id="fileTwo" name="fileTwo" /> <input type="submit" value="파일 업로드" />
	</form>
</body>
</html>