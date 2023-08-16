package member.controller;

import java.io.IOException;

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
		// 클라이언트의 요청을 반든 메소드
		// 전송방식이 get 방식으로 요청이 왔을 때 자동 연결됨


		// request : :
		// 사용자 input 으로 입력한 값, 쿼리스트링으로 전달한 값을 가지고 오는 객체임
		// 전송방식이 get 이면 request head 에 전송값이 기록되서 전송옴
		// 브라우저 주소표시줄에 보여짐
		// 전송방식이 post 이면 request body 에 전송값이 기록되서 전송옴
		// 브라우저 주소표시줄에 안보임

		// response :
		// 웹에서는 클라이언트와 서버 간의 request 와 response 가 쌍으로 왔다갔다함
		
		// 서비스를 요청한 클라이언트 정보를 가지고 있음(url ip 주소 등)
		// 서블릿 컨트롤러의 코드 작성 순서와 내용은 정해져 있음
		// 1. 전송온 값에 한글이 있다면 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		// 2. 전송온 값 꺼내서 변수 또는 vo 객체에 저장 처리함
		// String 변수 = request.getParameter("input의 name");
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		System.out.println("login : " + userid + ", " + userpwd);

		// 3. 서비스 메소드로 값 전달 실행 하고 결과받기
		Member loginMember = new MemberService().selectLogin(userid, userpwd);

		// 4. 받은 결과를 가지고 성공/실패 페이지 내보내기 작업
		if(loginMember != null && loginMember.getLoginOk().equals("Y")) { // login success
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			//System.out.println("get 방식으로 전송 요청됨...");
			// 로그인 상태 확인용 세션 객체 생성함
			HttpSession session = request.getSession(); // 세션이 있으면 가져오고 없으면 만들어라
			//session.setMaxInactiveInterval(30 * 60); // 30분동안 활동이 없으면 자동 파기함(로그아웃됨)

			System.out.println("생성된 세션 객체에 id : " + session.getId());

			//로그인한 회원의 정보를 세션객체에 저장함
			session.setAttribute("loginMember", loginMember);

			//로그인 성공시 내보낼 페이지 지정
			response.sendRedirect("index.jsp");

		}else { // login fail
			// 상대경로만 사용할 수 있음
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");

			// 클라이언트 브라우저로 내보낼 뷰 파일과 메세지 지정
			// 서블릿의 위치는 모두 root 에서 실행되고 있음

			if(loginMember != null && loginMember.getLoginOk().equals("N")) {
				// 지정한 뷰로 내보낼 값이 있다면
				request.setAttribute("message", "login fail! Blocked members");

			}else{
				request.setAttribute("message", "login fail! ID or Password is wrong.");
			}

			// 요청한 클라이언트로 전송함
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트의 요청을 받는 메소드
		// 전송방식(method)이 post 방식으로 요청이 왔을 때 자동 연결됨
		//System.out.println("post 방식으로 전송 요청됨...");
		doGet(request, response);
	}

}
