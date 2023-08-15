<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    isErrorPage="true" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body>

    </body>
        <h1> 오류 발생 : </h1>
        <%-- jps 내장객체 중 execption 객체 사용 :
             page 지시자 태그에 isErrorPage='true' 라고 지정했을때만
             exection 내장객체를 사용할 수 있음 --%>
        <%
            if(exception != null){ //jsp 페이지에서 발생한 에러이면
        %>
                <h3>jsp 페이지 오류 : <%= exception.getMessage() %></h3>
        <% 
           }else{   //jsp 페이지 에러가 아니라면(서블릿에서 넘긴 예외라면)
        %>
                <h3>Servlet 오류 : <%= request.getAttribute("message") %></h3>
        <%
           }
        %>
        <a href="/first/index.jsp">시작페이지로 이동</a>
    </html>