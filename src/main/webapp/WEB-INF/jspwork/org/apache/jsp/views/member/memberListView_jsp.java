/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.78
 * Generated at: 2023-08-17 07:10:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;
import java.util.ArrayList;
import member.model.vo.Member;

public final class memberListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/member/../common/menubar.jsp", Long.valueOf(1692240942404L));
    _jspx_dependants.put("/views/member/../common/footer.jsp", Long.valueOf(1691979495848L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
 
    ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    fieldset#ss{\r\n");
      out.write("        width: 600px;\r\n");
      out.write("        position: relative;\r\n");
      out.write("        left: 400px;\r\n");
      out.write("    }\r\n");
      out.write("    form fieldset{\r\n");
      out.write("        width: 600px;\r\n");
      out.write("    }\r\n");
      out.write("    form.sform{\r\n");
      out.write("        background-color: lightblue;\r\n");
      out.write("        width: 600px;\r\n");
      out.write("        position: relative;\r\n");
      out.write("        left: 400px;\r\n");
      out.write("        display: none;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>first</title>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/first/resources/js/jquery-3.7.0.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        $(function(){\r\n");
      out.write("            //input 태그 name이 item 의 값이 바뀌면(change) 작동되는 이벤트 핸들러 작성\r\n");
      out.write("            $('input[name=item]').on('change',function(){\r\n");
      out.write("                //여러 개의 태그 중에서 체크표시가 된 태그를 선택\r\n");
      out.write("                $('input[name=item]').each(function(index){\r\n");
      out.write("                    //선택된 radio 순번대로 하나씩 checked 인지 확인함\r\n");
      out.write("                    if($(this).is(':checked')){\r\n");
      out.write("                        //체크 표시된 아이템에 대한 폼이 보여지게 처리함\r\n");
      out.write("                        $('form.sform').eq(index).css('display','block');\r\n");
      out.write("                    }else{\r\n");
      out.write("                        //체크 표시 안된 아이템에 대한 폼은 안 보이게 처리함\r\n");
      out.write("                        $('form.sform').eq(index).css('display','none');\r\n");
      out.write("                    }\r\n");
      out.write("                });// each\r\n");
      out.write("            });// on\r\n");
      out.write("            \r\n");
      out.write("        }); //document ready\r\n");
      out.write("        function changeLogin(element){\r\n");
      out.write("            // radio 체크 상태가 변경된(change) input 태그의 name 속성 값에서 userid 를 분리추출\r\n");
      out.write("            var userid = element.name.substring(8);\r\n");
      out.write("            //console.log(\"userid : \"+ userid);\r\n");
      out.write("            if(element.checked == true && element.value == 'false'){\r\n");
      out.write("                //제한을 체크한 경우\r\n");
      out.write("               // console.log(\"로그인 제한을 체크함\");\r\n");
      out.write("               // 자바 스크립트에서 서블릿 사용은 로케이션(location)사용\r\n");
      out.write("               location.href=\"/first/loginok?userid=\" + userid +\"&ok=false\";\r\n");
      out.write("            }else{\r\n");
      out.write("                //가능을 체크한 경우\r\n");
      out.write("                //console.log(\"로그인 가능을 체크함\");\r\n");
      out.write("                location.href=\"/first/loginok?userid=\" + userid +\"&ok=true\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      out.write('\r');
      out.write('\n');

    // 로그인 확인을 위해서 내장된 session 객체를 이용
    Member loginMember = (Member)session.getAttribute("loginMember");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title></title>\r\n");
      out.write("    <style>\r\n");
      out.write("        nav > ul#menuber{\r\n");
      out.write("            list-style: none;\r\n");
      out.write("            position: relative;\r\n");
      out.write("            left: 150px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        nav > ul#menuber li {\r\n");
      out.write("            float: left;\r\n");
      out.write("            width: 120px;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("            margin-right: 5px;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("        nav > ul#menuber li a{\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            width: 120px;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("            display: block;\r\n");
      out.write("            background: orange;\r\n");
      out.write("            color: navy;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            text-shadow: 1px 1px 2px white;\r\n");
      out.write("            padding-top: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        nav > ul#menuber li a:hover{\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            width: 120px;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("            display: block;\r\n");
      out.write("            background: navy;\r\n");
      out.write("            color: white;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            text-shadow: 1px 1px 2px white;\r\n");
      out.write("            padding-top: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        hr {\r\n");
      out.write("            clear: both;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
 if(loginMember == null){ //로그인 하지 않았을 때 
      out.write("\r\n");
      out.write("    <nav>\r\n");
      out.write("        <ul id=\"menuber\">\r\n");
      out.write("            <li><a href=\"/first/index.jsp\">home</a></li>\r\n");
      out.write("            <li><a href=\"/first/nlist\">공지사항</a></li>\r\n");
      out.write("            <li><a href=\"/first/blist?page=1\">게시글</a></li>\r\n");
      out.write("            <li><a href=\"#\">QnA</a></li>\r\n");
      out.write("            <li><a href=\"/first/visws/testapi/testList.html\">테스트</a></li>\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
      out.write("\r\n");
 }else if(loginMember.getAdmin().equals("Y")){ // 관리자가 로그인 했을 때 
      out.write("\r\n");
      out.write("    <nav>\r\n");
      out.write("        <ul id=\"menuber\">\r\n");
      out.write("            <li><a href=\"/first/index.jsp\">home</a></li>\r\n");
      out.write("            <li><a href=\"/first/nlist.admin\">공지사항관리</a></li>\r\n");
      out.write("            <li><a href=\"/first/blist?page=1\">게시글관리</a></li>\r\n");
      out.write("            <li><a href=\"/first/mlist\">회원관리</a></li>\r\n");
      out.write("            <li><a href=\"/first/visws/testapi/testList.html\">테스트</a></li>\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
 }else{ 
      out.write("\r\n");
      out.write("    <nav>\r\n");
      out.write("        <ul id=\"menuber\">\r\n");
      out.write("            <li><a href=\"/first/index.jsp\">home</a></li>\r\n");
      out.write("            <li><a href=\"/first/nlist\">공지사항</a></li>\r\n");
      out.write("            <li><a href=\"/first/blist?page=1\">게시글</a></li>\r\n");
      out.write("            <li><a href=\"#\">암호화 회원가입</a></li>\r\n");
      out.write("            <li><a href=\"#\">QnA</a></li>\r\n");
      out.write("            <li><a href=\"/first/visws/testapi/testList.html\">테스트</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </nav>\r\n");
 } 
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("    <hr>\r\n");
      out.write("    <h1 align=\"center\">전체 회원 관리 페이지</h1>\r\n");
      out.write("    <h2 align=\"center\">현재 회원수 : ");
      out.print( memberList.size());
      out.write(" 명</h2>\r\n");
      out.write("    <br>\r\n");
      out.write("    <center>\r\n");
      out.write("        <button onclick=\"javascript:location.href='/first/mlist';\">전체 목록 보기</button>\r\n");
      out.write("    </center>\r\n");
      out.write("    <br>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("        <fieldset id=\"ss\" style=\"width: 600px; position: relative; left: 400px;\">\r\n");
      out.write("            <legend>검색할 항목을 선택하세요.</legend>\r\n");
      out.write("            <input type=\"radio\" name=\"item\" id=\"uid\"> 회원 아이디 &nbsp;\r\n");
      out.write("            <input type=\"radio\" name=\"item\" id=\"ugen\"> 성별 &nbsp;\r\n");
      out.write("            <input type=\"radio\" name=\"item\" id=\"uage\"> 연령대 &nbsp;\r\n");
      out.write("            <input type=\"radio\" name=\"item\" id=\"uenroll\"> 가입날짜 &nbsp;\r\n");
      out.write("            <input type=\"radio\" name=\"item\" id=\"ulogok\"> 로그인 제한 여부 &nbsp;\r\n");
      out.write("        </fieldset>\r\n");
      out.write("    <br>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action=\"/first/msearch\" id=\"idform\" class=\"sform\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"id\">\r\n");
      out.write("            <fieldset>\r\n");
      out.write("                <legend>검색할 아이디를 입력하세요</legend>\r\n");
      out.write("                <input type=\"search\" name=\"keyword\"> &nbsp;\r\n");
      out.write("                <input type=\"submit\" value=\"검색\">\r\n");
      out.write("            </fieldset>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action=\"/first/msearch\" id=\"genderform\" class=\"sform\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"gender\">\r\n");
      out.write("            <fieldset>\r\n");
      out.write("                <legend>검색할 성별을 선택하세요</legend>\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"M\"> 남자 &nbsp;\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"F\"> 여자 &nbsp;\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"T\"> 제3성 &nbsp;\r\n");
      out.write("                <input type=\"submit\" value=\"검색\">\r\n");
      out.write("            </fieldset>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action=\"/first/msearch\" id=\"ageform\" class=\"sform\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"age\">\r\n");
      out.write("            <fieldset>\r\n");
      out.write("                <legend>검색할 연령대를 입력하세요</legend>\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"20\">20대 &nbsp;\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"30\">30대 &nbsp;\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"40\">40대 &nbsp;\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"50\">50대 &nbsp;\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"60\">60대 이상 &nbsp;\r\n");
      out.write("                <input type=\"submit\" value=\"검색\">\r\n");
      out.write("            </fieldset>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action=\"/first/msearch\" id=\"enrollform\" class=\"sform\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"enrolldate\">\r\n");
      out.write("            <fieldset>\r\n");
      out.write("                <legend>검색할 가입 날짜를 선택하세요</legend>\r\n");
      out.write("                <input type=\"date\" name=\"begin\"> ~\r\n");
      out.write("                <input type=\"date\" name=\"end\"> &nbsp;\r\n");
      out.write("                <input type=\"submit\" value=\"검색\">\r\n");
      out.write("            </fieldset>\r\n");
      out.write("        </form>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <form action=\"/first/msearch\" id=\"lokform\" class=\"sform\" method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"loginok\">\r\n");
      out.write("            <fieldset>\r\n");
      out.write("                <legend>검색할 로그인 제한/가능 을 선택하세요 선택하세요</legend>\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"Y\"> 로그인 가능 회원 &nbsp;\r\n");
      out.write("                <input type=\"radio\" name=\"keyword\" value=\"N\"> 로그인 제한 회원 &nbsp;\r\n");
      out.write("                <input type=\"submit\" value=\"검색\">\r\n");
      out.write("            </fieldset>\r\n");
      out.write("        </form>\r\n");
      out.write("    <br>\r\n");
      out.write("    \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    <table align=\"center\" border=\"1\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>아이디</th>\r\n");
      out.write("            <th>이름</th>\r\n");
      out.write("            <th>성별</th>\r\n");
      out.write("            <th>나이</th>\r\n");
      out.write("            <th>전화번호</th>\r\n");
      out.write("            <th>이메일</th>\r\n");
      out.write("            <th>가입날짜</th>\r\n");
      out.write("            <th>마지막 수정날짜</th>\r\n");
      out.write("            <th>가입방식</th>\r\n");
      out.write("            <th>관리자여부</th>\r\n");
      out.write("            <th>로그인 제한여부</th>    \r\n");
      out.write("            ");
 for(Member m : memberList){ 
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>");
      out.print( m.getUserId() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( m.getUserName() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( m.getGender().equals("M")? "남자": m.getGender().equals("F")?"여자":"3성" );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( m.getAge() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( m.getPhone() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( m.getEmail() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( m.getEnrollDate() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( m.getLastModified() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( m.getSignType() );
      out.write("</td>\r\n");
      out.write("                    <td>");
      out.print( m.getAdmin() );
      out.write("</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        ");
 if(m.getLoginOk().equals("Y")){
      out.write("\r\n");
      out.write("                            <input type=\"radio\" name=\"loginok_");
      out.print( m.getUserId() );
      out.write("\" value=\"true\"\r\n");
      out.write("                             onchange=\"changeLogin(this)\" checked> 가능 &nbsp;\r\n");
      out.write("                            <input type=\"radio\" name=\"loginok_");
      out.print( m.getUserId() );
      out.write("\" value=\"false\"\r\n");
      out.write("                             onchange=\"changeLogin(this)\"> 제한\r\n");
      out.write("                        ");
}else{
      out.write("\r\n");
      out.write("                            <input type=\"radio\" name=\"loginok_");
      out.print( m.getUserId() );
      out.write("\" value=\"true\"\r\n");
      out.write("                             onchange=\"changeLogin(this)\"> 가능 &nbsp;\r\n");
      out.write("                            <input type=\"radio\" name=\"loginok_");
      out.print( m.getUserId() );
      out.write("\" value=\"false\"\r\n");
      out.write("                             onchange=\"changeLogin(this)\" checked> 제한\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr> \r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    <hr>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title></title>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        footer{\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            background-color: navy;\r\n");
      out.write("            color: whitesmoke;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <footer>\r\n");
      out.write("        Copyright@ict.org &nbsp; 지능형 도우미 서비스 융합 웹 개발자과정 <br>\r\n");
      out.write("        서울시 서초구 서초대로77길 41, 4층(서초동) TEL : 02-1234-5678, FAX : 02-1234-5679\r\n");
      out.write("    </footer>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
