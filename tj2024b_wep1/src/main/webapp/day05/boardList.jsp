<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>게시판</h1>
    
    <!-- 게시물 등록 영역 -->
    <div>
        <h3>게시물 등록</h3>
        <form id="writeForm">
            <div>
                <label>제목</label>
                <input type="text" name="btitle" required>
            </div>
            <div>
                <label>내용</label>
                <textarea name="bcontent" required></textarea>
            </div>
            <div>
                <label>작성자</label>
                <input type="text" name="bwriter" required>
            </div>
            <div>
                <label>비밀번호</label>
                <input type="password" name="bpwd" required>
            </div>
            <button type="submit">등록</button>
        </form>
    </div>

    <!-- 게시물 목록 영역 -->
    <div>
        <h3>게시물 목록</h3>
        <table border="1">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody id="boardList">
                <!-- 여기에 게시물 목록이 동적으로 추가됨 -->
            </tbody>
        </table>
    </div>

    <script src="js/boardList.js"></script>
</body>
</html>