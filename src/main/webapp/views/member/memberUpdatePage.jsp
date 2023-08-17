<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%
    Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>first</title>
<style type="text/css">
table th {
	background-color: #9ff;
}

table#outer {
	border: 2px solid navy;
}
</style>
</head>
<body>
	<h1 align="center">회원 정보 수정 페이지</h1>
	<br>
	<form action="/first/mupdate" method="post">
<table id="outer" align="center" width="500" cellsapcing="5" cellpadding="0">
   <tr><th colspan="2">등록된 회원정보는 아래와 같습니다. <br> 
               수정할 내용이 있으면 변경하고 수정하기 버튼을 누르세요. </th></tr>
   <tr><th width="120">아이디</th>
      <td> <input type="text" name="userid" value="<%= member.getUserId() %>" readonly> &nbsp;
      <input type="button" value="중복확인" onclick="return dupIDCheck();"></td></tr>
   
   <tr><th>이름</th>
      <td><input type="text" name="username"  value="<%= member.getUserName() %>" readonly></td></tr>
   <tr>
				<th>성별</th>
				<td>
					<% if(member.getGender().equals("M")){%> <input type="radio"
					name="gender" value="M" checked>남자 &nbsp; <input
					type="radio" name="gender" value="F">여자 &nbsp; <input
					type="radio" name="gender" value="T">제3의성 &nbsp; <%}else if(member.getGender().equals("F")){%>
					<input type="radio" name="gender" value="M">남자 &nbsp; <input
					type="radio" name="gender" value="F" checked>여자 &nbsp; <input
					type="radio" name="gender" value="T">제3의성 &nbsp; <%}else{%> <input
					type="radio" name="gender" value="M">남자 &nbsp; <input
					type="radio" name="gender" value="F">여자 &nbsp; <input
					type="radio" name="gender" value="T" checked>제3의성 &nbsp; <%}%>
				</td>
			</tr>
      
   <tr><th>나이</th>
      <td> <input type="number" name="age" min="19" value="<%= member.getAge() %>"></tr>
   <tr><th>전화번호</th>
      <td> <input type="tel" name="phone" value="<%= member.getPhone() %>"></td></tr>
   <tr><th>이메일</th>
      <td> <input type="email" name="email" value="<%= member.getEmail() %>"></td></tr>
   <tr><th>취미(연습용)</th>
   <%
      //예를 들어, hobby로 응답 온 값이 "game,sport,cook"인 경우
      String hobby = "game,sport,cook";
   
      //하나의 문장을 ","로 각각 분리 처리
      String[] hobbies = hobby.split(",");
      
      //checkbox의 checked 속성 설정을 위한 배열을 만듦 : checkbox 갯수만큼
      String[] checked = new String[9];
      
      for(String hb : hobbies){
         switch(hb){
         case "game": checked[0] = "checked"; break;
         case "reading": checked[1] = "checked"; break;
         case "climb": checked[2] = "checked"; break;
         case "sport": checked[3] = "checked"; break;
         case "music": checked[4] = "checked"; break;
         case "movie": checked[5] = "checked"; break;
         case "travle": checked[6] = "checked"; break;
         case "cook": checked[7] = "checked"; break;
         case "etc": checked[8] = "checked"; break;
         
         }
      }
      
   %>
      <td> <table width="350">
         <tr> 
            <td> <input type="checkbox" name="hobby" value="간" <%= checked[0] %>> 간</td>
            <td> <input type="checkbox" name="hobby" value="신장" <%= checked[1] %>> 신장</td>
            <td> <input type="checkbox" name="hobby" value="폐" <%= checked[2] %>> 폐</td>
         </tr>
         <tr> 
            <td> <input type="checkbox" name="hobby" value="각막" <%= checked[3] %>> 각막</td>
            <td> <input type="checkbox" name="hobby" value="심장" <%= checked[4] %>> 심장</td>
            <td> <input type="checkbox" name="hobby" value="소장" <%= checked[5] %>> 소장</td>
         </tr>
         <tr> 
            <td> <input type="checkbox" name="hobby" value="심장동맥" <%= checked[6] %>> 심장동맥</td>
            <td> <input type="checkbox" name="hobby" value="쓸개" <%= checked[7] %>> 쓸개</td>
            <td> <input type="checkbox" name="hobby" value="혈액" <%= checked[8] %>>혈액</td>
         </tr>
         
      </table>
   </td></tr>
   <tr><th>기타 정보(연습용)</th>
      <td> <textarea name="etc" cols="50" rows="3"></textarea></td></tr>
   <tr><th colspan="2">
      <input type="submit" value="수정하기">&nbsp;
      <a href="/first/mdel?userid=<%= member.getUserId() %>">탈퇴하기</a>
      <a href="javascript:history.go(-1);">이전 페이지로 이동</a>&nbsp;
      <a href="/first/index.jsp">시작페이지로 이동</a>
   </th></tr>

</table>
</form>
</body>
</html>