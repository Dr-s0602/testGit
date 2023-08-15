<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" errorPage="views/common/error.jsp" %>
<%-- include 한 member.jsp 가 가지고 온 loginMember 와 충돌 발생함 --%>
<%-- <%@ page import="member.model.vo.Member" %>
<% 
    Member loginMember = (Member)session.getAttribute("loginMember");
 %> --%>
<%-- <%@ %> 이 지시자 태그는 jsp 첫줄에 있어야 한다--%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>first</title>
    <style type="text/css">
        div.lineA {
            height: 100px;
            border: 1px solid gray;
            float: left;
            position: relative;
            left: 120px;
            margin: 5px;
            padding: 5px;
        }

        div#banner {
            width: 500px;
            padding: 0;

        }

        div#banner img {
            width: 450px;
            height: 80px;
            padding: 0;
        }

        div#loginBox {
            width: 280px;
            font-size: 10pt;
            text-align: left;
            padding-left: 20px;
        }

        div#loginBox button {
            width: 250px;
            height: 35px;
            background-color: navy;
            color: white;
            margin-top: 10px;
            margin-bottom: 15px;
            font-size: 14px;
            font-weight: bold;
        }

    </style>
    <script type="text/javascript">
        function movePage(){
            //자바스크립트로 페에지 이동 또는 서블릿 컨트롤러 연결 요청시
            //location 내장객체의 href 속성을 사용함
            location.href = "/first/views/member/loginPage.html";
        }
    </script>
</head>
<body>
<h1>firstWebProject : first</h1>
<%-- <% 
	int num = 5, div = 0;
%>
<%= num/div %> --%>
<%-- 메뉴바 표시 --%>
<%@ include file="views/common/meunbar.jsp" %>
<hr>
<center>
    <div id="banner" class="lineA">
        <img src="/first/resources/images/photo2.jpg">
    </div>
    <%-- 로그인하지 않은 상태일 때 --%>
    <% if (loginMember == null) { %>
    <div id="loginBox" class="lineA">
        first 사이트 방문을 환영합니다.
        <button onclick="movePage();">로그인 하세요</button>
        <br>
        <a>아이디/비밀번호 조회</a> &nbsp;
        <a href="/first/views/member/enrollPage.html">회원가입</a>
    </div>
    <% } else { %>
    <div id="loginBox" class="lineA">
        <%= loginMember.getUserName() %> 님 &nbsp;
        <a href="/first/logout">로그아웃</a><br>
        <a>메일</a>&nbsp;<a>채팅</a>&nbsp;<a>쪽지</a>
        <a href="/first/myinfo?userid=<%= loginMember.getUserId()%>">My Page</a>
        <%--
            a 태그로 서버 컨트롤러(서블릿)로 값을 전송하는 방법 :
            쿼리 스트링(query string) 사용함
            ?전송이름=전송값&전송이름=전송값 (공백이 없도록 주의함)
            a href="연결대상?전송이름=전송값"
            a 태그의 전송 method 는 get 임
         --%>
    </div>
    <% } %>
</center>
<hr style="clear: both;">
<%-- jsp 파일 안에 별도로 작성된 jsp, html 파일을 포함할 수 있다.
     주의 : 상대경로만 사용할 수 있음
 --%>
<%@ include file="./views/common/footer.jsp" %>
</body>
</html>