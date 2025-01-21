<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>대기명단관리</h3>
	<!-- 대기등록구역 -->
	<div>
		<h4>대기등록</h4>
		전화번호 : <input type="text" class ="phoneInput"/><br/>
		인원수 : <input type ="number" class ="pnoInput"/><br/>
		<button onclick="waitingWrite( )"type=button>등록</button>
	</div>
	<!-- 대기명단 목록 -->
	<div>
		<h4>대기 명단 목록</h4>
		<table border="1">
			<thead>
				<tr>
					<th>대기번호</th>
					<th>전화번호</th>
					<th>인원수</th>
				</tr>
			</thead>
			<tbody>
				<!-- JS가 데이터 출력해줌 -->
			</tbody>
		</table>
	</div>

	<script src="task2.js"></script>
</body>
</html>