<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member,java.util.ArrayList"%>
<% 
    ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <%@ include file="../common/menubar.jsp" %>
    <hr>
    <h1 align="center">전체 회원 관리 페이지</h1>
    <h2 align="center">현재 회원수 : <%= memberList.size()%> 명</h2>
    <br>
    <center>
        <button onclick="javascript:location.href='/first/mlist';">전체 목록 보기</button>
    </center>
    <br>
    <%-- 항목별 검색 기능 추가 --%>
    <br>
    <%-- 전체 회원 정보 출력 --%>
    <table align="center" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>성별</th>
            <th>나이</th>
            <th>전화번호</th>
            <th>이메일</th>
            <th>가입날짜</th>
            <th>마지막 수정날짜</th>
            <th>가입방식</th>
            <th>관리자여부</th>
            <th>로그인 제한여부</th>    
            <% for(Member m : memberList){ %>
                <tr>
                    <td><%= m.getUserId() %></td>
                    <td><%= m.getUserName() %></td>
                    <td><%= m.getGender().equals("M")? "남자": m.getGender().equals("F")?"여자":"3성" %></td>
                    <td><%= m.getAge() %></td>
                    <td><%= m.getPhone() %></td>
                    <td><%= m.getEmail() %></td>
                    <td><%= m.getEnrollDate() %></td>
                    <td><%= m.getLastModified() %></td>
                    <td><%= m.getSignType() %></td>
                    <td><%= m.getAdmin() %></td>
                    <td><%= m.getLoginOk() %></td>
                </tr> 
            <% } %>
        </tr>
    </table>
    <hr>
    <%@ include file="../common/footer.jsp" %>
</body>

</html>