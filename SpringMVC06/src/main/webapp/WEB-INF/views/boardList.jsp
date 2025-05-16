<%@page import="com.lgdx.entity.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Spring MVC 05</h2>
		<div class="panel panel-warning">
			<div class="panel-heading">Board List Page</div>
			<div class="panel-body">
				<table class = "table table-bordered table-hover">
					<tr class ="success">
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>조회수</td>
						<td>날짜</td>
					</tr>
					<% 
					//Model이라는 저장소는 request안에 포함되어있다
					//다운캐스팅 해야함 왜? object타입으로 가져왔으니까
					//getAttribute("key값")
					ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
					
					for(int i=0; i<list.size(); i++){%>
					<tr>
						<td><%=list.get(i).getIdx() %></td>
						<td><a href="boardContents.do?idx=<%=list.get(i).getIdx() %>"><%=list.get(i).getTitle() %></a></td>
						<td><%=list.get(i).getWriter() %></td>
						<td><%=list.get(i).getCount() %></td>
						<td><%=list.get(i).getIndate() %></td>
					</tr>
					
					<%} %>
				</table>
				<a class="btn btn-warning" href="boardInsert.do">글쓰기</a>
				
			</div>
			<div class="panel-footer">LG DX - 임은영</div>
		</div>
	</div>
</body>
</html>