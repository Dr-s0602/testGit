<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
    
<%
   Member member = (Member)request.getAttribute("member");

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
   table th {background-color:    #FFDBE1; }
   table#outer {border: 2px solid pink;}
</style>
</head>
<body>
<%@ include file="../common/meunbar.jsp" %>
<hr>
<h1>내 정보 보기 : 마이 페이지</h1> 
<br>
<table id="outer" align="center" width="500" cellsapcing="5" cellpadding="0">
   <tr><th colspan="2">등록된 회원정보는 아래와 같습니다. <br>
                수정할 내용이 있으면 '수정페이지로 이동' 버튼을 누르세요.</th></tr>
   <tr><th width="120">아이디</th>   <td><%= member.getUserId() %> </td></tr>
   
   <tr><th>이름</th><td><%= member.getUserName() %></td></tr>
   <tr><th>성별</th><td><%= (member.getGender().equals("M"))?"남자":"여자" %></td></tr>
   <tr><th>나이</th><td><%= member.getAge() %> </td> </tr>
      <tr><th>전화번호</th><td><%= member.getPhone() %></td></tr>
   <tr><th>이메일</th>   <td><%= member.getEmail() %> </td></tr>
   
   <tr><th colspan="2">
      <button onclick="javascript:location.href='/first/moveup?userid=<%= member.getUserId() %>';" >수정페이지로 이동</button>&nbsp;
      &nbsp;
      <a href="/first/index.jsp">시작페이지로 이동</a>
   </th></tr>

</table>




</body>
</html>