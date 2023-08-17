<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member,java.util.ArrayList"%>
<% 
    ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>first</title>
    <script type="text/javascript">
        function changeLogin(element){
            // radio 체크 상태가 변경된(change) input 태그의 name 속성 값에서 userid 를 분리추출
            var userid = element.name.substring(8);
            //console.log("userid : "+ userid);
            if(element.checked == true && element.value == 'false'){
                //제한을 체크한 경우
               // console.log("로그인 제한을 체크함");
               // 자바 스크립트에서 서블릿 사용은 로케이션(location)사용
               location.href="/first/loginok?userid=" + userid +"&ok=false";
            }else{
                //가능을 체크한 경우
                //console.log("로그인 가능을 체크함");
                location.href="/first/loginok?userid=" + userid +"&ok=true";
            }
        }
    </script>
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
        <fieldset id="ss" style="width: 600px; position: relative; left: 400px;">
            <legend>검색할 항목을 선택하세요.</legend>
            <input type="radio" name="item" id="uid"> 회원 아이디 &nbsp;
            <input type="radio" name="item" id="ugen"> 성별 &nbsp;
            <input type="radio" name="item" id="uage"> 연령대 &nbsp;
            <input type="radio" name="item" id="uenroll"> 가입날짜 &nbsp;
            <input type="radio" name="item" id="ulogok"> 로그인 제한 여부 &nbsp;
        </fieldset>
    <br>
        <%-- 검색 항목별 값 입력 전송용 폼 만들기 --%>
        <%-- 회원 아이디 검색 폼 --%>
        <form action="/first/msearch" id="idform" class="sform" method="post">
            <input type="hidden" name="action" value="id">
            <fieldset>
                <legend>검색할 아이디를 입력하세요</legend>
                <input type="search" name="keyword"> &nbsp;
                <input type="submit" value="검색">
            </fieldset>
        </form>
        <%-- 회원 성별 검색 폼 --%>
        <form action="/first/msearch" id="genderform" class="sform" method="post">
            <input type="hidden" name="action" value="gender">
            <fieldset>
                <legend>검색할 성별을 선택하세요</legend>
                <input type="radio" name="keyword" value="M"> 남자 &nbsp;
                <input type="radio" name="keyword" value="F"> 여자 &nbsp;
                <input type="radio" name="keyword" value="T"> 제3성 &nbsp;
                <input type="submit" value="검색">
            </fieldset>
        </form>
        <%-- 회원 연령대 검색 폼 --%>
        <form action="/first/msearch" id="ageform" class="sform" method="post">
            <input type="hidden" name="action" value="age">
            <fieldset>
                <legend>검색할 연령대를 입력하세요</legend>
                <input type="radio" name="keyword" value="20">20대 &nbsp;
                <input type="radio" name="keyword" value="30">30대 &nbsp;
                <input type="radio" name="keyword" value="40">40대 &nbsp;
                <input type="radio" name="keyword" value="50">50대 &nbsp;
                <input type="radio" name="keyword" value="60">60대 이상 &nbsp;
                <input type="submit" value="검색">
            </fieldset>
        </form>
        <%-- 회원 가입날짜 검색 폼 --%>
        <form action="/first/msearch" id="enrollform" class="sform" method="post">
            <input type="hidden" name="action" value="enrolldate">
            <fieldset>
                <legend>검색할 가입 날짜를 선택하세요</legend>
                <input type="date" name="begin"> ~
                <input type="date" name="end"> &nbsp;
                <input type="submit" value="검색">
            </fieldset>
        </form>
        <%-- 회원 로그인제한 검색 폼 --%>
        <form action="/first/msearch" id="lokform" class="sform" method="post">
            <input type="hidden" name="action" value="goinok">
            <fieldset>
                <legend>검색할 로그인 제한/가능 을 선택하세요 선택하세요</legend>
                <input type="radio" name="keyword" value="Y"> 로그인 가능 회원 &nbsp;
                <input type="radio" name="keyword" value="N"> 로그인 제한 회원 &nbsp;
                <input type="submit" value="검색">
            </fieldset>
        </form>
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
                    <td>
                        <%-- 관리자가 회원의 로그인 제한을 설정할 수 있도록 함 --%>
                        <% if(m.getLoginOk().equals("Y")){%>
                            <input type="radio" name="loginok_<%= m.getUserId() %>" value="true"
                             onchange="changeLogin(this)" checked> 가능 &nbsp;
                            <input type="radio" name="loginok_<%= m.getUserId() %>" value="false"
                             onchange="changeLogin(this)"> 제한
                        <%}else{%>
                            <input type="radio" name="loginok_<%= m.getUserId() %>" value="true"
                             onchange="changeLogin(this)"> 가능 &nbsp;
                            <input type="radio" name="loginok_<%= m.getUserId() %>" value="false"
                             onchange="changeLogin(this)" checked> 제한
                        <%}%>
                    </td>
                </tr> 
            <% } %>
        </tr>
    </table>
    <hr>
    <%@ include file="../common/footer.jsp" %>
</body>

</html>