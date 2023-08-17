<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="member.model.vo.Member" %>
<%
    // 로그인 확인을 위해서 내장된 session 객체를 이용
    Member loginMember = (Member)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        nav > ul#menuber{
            list-style: none;
            position: relative;
            left: 150px;
        }

        nav > ul#menuber li {
            float: left;
            width: 120px;
            height: 30px;
            margin-right: 5px;
            padding: 0;
        }
        nav > ul#menuber li a{
            text-decoration: none;
            width: 120px;
            height: 30px;
            display: block;
            background: orange;
            color: navy;
            text-align: center;
            font-weight: bold;
            margin: 0;
            text-shadow: 1px 1px 2px white;
            padding-top: 5px;
        }
        nav > ul#menuber li a:hover{
            text-decoration: none;
            width: 120px;
            height: 30px;
            display: block;
            background: navy;
            color: white;
            text-align: center;
            font-weight: bold;
            margin: 0;
            text-shadow: 1px 1px 2px white;
            padding-top: 5px;
        }

        hr {
            clear: both;
        }


    </style>
</head>
<body>
<% if(loginMember == null){ //로그인 하지 않았을 때 %>
    <nav>
        <ul id="menuber">
            <li><a href="/first/index.jsp">home</a></li>
            <li><a href="/first/nlist">공지사항</a></li>
            <li><a href="/first/blist?page=1">게시글</a></li>
            <li><a href="#">QnA</a></li>
            <li><a href="/first/visws/testapi/testList.html">테스트</a></li>

        </ul>
    </nav>

<% }else if(loginMember.getAdmin().equals("Y")){ // 관리자가 로그인 했을 때 %>
    <nav>
        <ul id="menuber">
            <li><a href="/first/index.jsp">home</a></li>
            <li><a href="/first/mlist.admin">공지사항관리</a></li>
            <li><a href="/first/blist?page=1">게시글관리</a></li>
            <li><a href="/first/mlist">회원관리</a></li>
            <li><a href="/first/visws/testapi/testList.html">테스트</a></li>

        </ul>
    </nav>
<% }else{ %>
    <nav>
        <ul id="menuber">
            <li><a href="/first/index.jsp">home</a></li>
            <li><a href="/first/nlist">공지사항</a></li>
            <li><a href="/first/blist?page=1">게시글</a></li>
            <li><a href="#">암호화 회원가입</a></li>
            <li><a href="#">QnA</a></li>
            <li><a href="/first/visws/testapi/testList.html">테스트</a></li>
        </ul>
    </nav>
<% } %>
</body>
</html>