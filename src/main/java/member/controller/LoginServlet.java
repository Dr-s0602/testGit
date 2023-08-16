package member.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 클라이언트의 요청을 받는 메소드
      // 전송방식이 get 방식으로 요청이 왔을 때 자동 연결됨
      
      //request :
      //사용자 input으로 입력한 값, 쿼리스트링으로 전달한 값을 가지고 오는 객체임
      //전송방식이 get 이면 request head에 전송값이 기록되서 전송옴
      //브라우저 주소표시줄에 보여짐
      //전송방식이 post 이면 request body에 전송값이 기록되어 전송옴
      //브라우저 주소표시줄에 안 보임
      
      //response :
      //서비스를 요청한 클라이언트 정보를 가지고 있음 (url ip 주소 등)
      //웹에서는 클라이언트와 서버 간의 request 와 response 가 쌍으로 왔다갔다함
      
      //서블릿 컨트롤러의 코드 작성 순서와 내용은 정해져 있음 
      
      //1. 전송 온 값에 한글이 있다면 인코딩 처리함
      request.setCharacterEncoding("UTF-8");
      
      //2. 전송 온 값 꺼내서 변수 또는 vo 객체에 저장 처리함
      //String 변수 = request.getParameter("input의 name");
      String userid = request.getParameter("userid");
      String userpwd = request.getParameter("userpwd");

      //패스워드 암호화 처리
      //웹에서는 암호화 처리에 단방향 알고리즘 사용함 : SHA-512
      //java.security.MessageDigest 클래스 이용함
      String cryptoUserpwd = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			//패스워드 문자열을 암호문으로 바꾸려면, byte[]로 변환해야 함
			
			byte[] pwdValues = userpwd.getBytes(Charset.forName("UTF-8"));
			// 암호문으로 바꾸기
			
			md.update(pwdValues);
			//암호화된 byte[] 을 String  으로 바꿈 : 암호문 상태임
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			
			//확인 
			// System.out.println("암호화된 패스워드 : "+cryptoUserpwd);
			// System.out.println("암호화된 패스워드 길이 : "+cryptoUserpwd.length());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
      

      //System.out.println("login : " + userid + ", " + userpwd);
      
      //3. 서비스 메소드로 값 전달 실행하고 결과 받기
      //Member loginMember = new MemberService().selectLogin(userid, userpwd);
      Member loginMember = new MemberService().selectLogin(userid, cryptoUserpwd);
      
      //4. 받은 결과를 가지고 성공/실패 페이지 내보내기
      if(loginMember != null && loginMember.getLoginOk().equals("Y")) {   //로그인 성공
         //로그인 상태 확인용 세션 객체 생성함
         HttpSession session = request.getSession();   //import javax.servlet.http.HttpSession;
         //session.setMaxInactiveInterval(30 * 60); //30분동안 활동이 없으면 자동 파기함(로그아웃됨)
         
         System.out.println("생성된 세션 객체의 id : " + session.getId());
         
         //로그인한 회원의 정보를 세션객체에 저장함 
         session.setAttribute("loginMember", loginMember);
          
         //로그인 성공시 내보낼 페이지 지정
         response.sendRedirect("index.jsp");
         
      } else {   //로그인 실패
         //클라이언트 브라우저로 내보낼 뷰 파일과 메세지 지정
         //서블릿의 위치는 모두 root 에서 실행되고 있음
         
         //상대경로만 사용할 수 있음
         RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
         
         //지정한 뷰로 내보낼 값이 있다면
         if(loginMember != null && loginMember.getLoginOk().equals("N")) {
            request.setAttribute("message","로그인이 제한된 회원입니다. 관리자에게 문의하세요.");
         }
         if(loginMember == null) {
         request.setAttribute("message", "로그인 실패! 아이디 또는 암호를 다시 확인하고 로그인하세요.");
         }
         //요청한 클라이언트로 전송함
         view.forward(request, response);
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // 클라이언트의 요청을 받는 메소드
      // 전송방식(method)이 post 방식으로 요청이 왔을 때 자동 연결됨
      //System.out.print("post 방식으로 전송 요청옴.");
      doGet(request, response);
   }

}