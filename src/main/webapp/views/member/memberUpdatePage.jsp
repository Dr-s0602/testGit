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
        <table id="outer" align="center" width="500" cellspacing="5" cellpadding="0">
            <tr>
                <th colspan="2">등록된 회원정보는 아래와 같습니다. <br>
                 수정할 내용이 있으면 변경하고 수정하기 버튼을 누르세요.</th>
            </tr>
            <tr>
                <th width="120">아이디</th>
                <td><input type="text" name="userid" value="<%= member.getUserid() %>" readonly> &nbsp;
                </td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="username" value="<%= member.getUsername() %>" readonly></td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
                    <% if(member.getGender().equals("M")){%>
                        <input type="radio" name="gender" value="M" checked>남자 &nbsp;
                        <input type="radio" name="gender" value="F">여자 &nbsp;
                        <input type="radio" name="gender" value="T">제3의성 &nbsp;
                    <%}else if(member.getGender().equals("F")){%>
                        <input type="radio" name="gender" value="M">남자 &nbsp;
                        <input type="radio" name="gender" value="F" checked>여자 &nbsp;
                        <input type="radio" name="gender" value="T">제3의성 &nbsp;
                    <%}else{%>
                        <input type="radio" name="gender" value="M" >남자 &nbsp;
                        <input type="radio" name="gender" value="F" >여자 &nbsp;
                        <input type="radio" name="gender" value="T" checked>제3의성 &nbsp;
                    <%}%>
                </td>
            </tr>
            <tr>
                <th>나이</th>
                <td><input type="number" name="userage" min="19" value="20" required></td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td><input type="tel" name="phone" required></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <th>원하는 부위</th>
                <td>
                    <table width="350">
                        <tr>
                            <td><input type="checkbox" name="hobby" value="간">간</td>
                            <td><input type="checkbox" name="hobby" value="신장">신장</td>
                            <td><input type="checkbox" name="hobby" value="폐">폐</td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="hobby" value="각막">각막</td>
                            <td><input type="checkbox" name="hobby" value="심장">심장</td>
                            <td><input type="checkbox" name="hobby" value="소장">소장</td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="hobby" value="심장동맥">심장동맥</td>
                            <td><input type="checkbox" name="hobby" value="쓸개">쓸개</td>
                            <td><input type="checkbox" name="hobby" value="혈액">혈액</td>
                        </tr>
                    </table>

                </td>
            </tr>
            <tr>
                <th>기타 정보</th>
                <td><textarea name="etc" cols="50" rows="3"></textarea></td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" value="수정하기"> &nbsp;
                    <a href="/first/mdel?userid=<%= member.getUserid() %>">탈퇴하기</a>
                    <a href="javascript:history.go(-1)">이전 페이지로</a>
                    <a href="/first/index.jsp">시작 페이지로</a>
                </th>
            </tr>
        </table>
    </form>
</body>
</html>