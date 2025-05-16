<%@page import="com.lgdx.entity.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    Board board = (Board) request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
	body {
		margin: 0;
		padding: 0;
	}
	.panel-footer {
		margin-bottom: 0;
	}
</style>
</head>
<body>
<div class="container">
	<h2>Spring MVC 05</h2>
	<div class="panel panel-warning">
		<div class="panel-heading">Board Contents Page</div>
		<div class="panel-body">
			<table class="table table-bordered table-hover">
				<tr>
					<td><strong>제목</strong></td>
					<td><%= board.getTitle() %></td>
					<td><strong>작성자</strong></td>
					<td><%= board.getWriter() %></td>
				</tr>
				<tr>
					
					<td colspan="4" style="text-align: center;"><%= board.getContents().replaceAll("\n", "<br>") %></td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<a href="boardList.do"><button type="button" class="btn btn-success">돌아가기</button></a>
						<!-- 
							BoardController에 boardDelete.do 요청시
							해당 idx와 일치하는 게시글을 삭제하고
							boardList.jsp 페이지로 이동하시오
							힌트. 상세보기를 잘 살펴보면 매우 흡사하다
						 -->
						<a href="boardDelete.do?idx=<%=board.getIdx()%>"><button type="button" class="btn btn-danger">삭제</button></a>
						<a href="boardUpdate.do?idx=<%=board.getIdx()%>"><button type="button" class="btn btn-warning">수정</button></a>
					</td>
				</tr>
			</table>
		</div>
		<div class="panel-footer">LG DX - 임은영</div>
	</div>
</div>
</body>
</html>
