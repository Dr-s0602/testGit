package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 수정 처리용 컨트롤러

		// 1. 전송온 값에 한글이 있으면 인코딩 처리함
		request.setCharacterEncoding("UTF-8");

		// 2. 전송온 값에 꺼내서 변수 혹은 객체에 저장 [넘어온 값이 하나 이상이라면 객체에 담아서 처리]
		Member member = new Member();

		member.setUserId(request.getParameter("userid"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setPhone(request.getParameter("phone"));
		member.setEmail(request.getParameter("email"));

		// 3. 모델 서비스 메소드로 값 또는 객체 전달 실행하고 결과 받기

		int result = new MemberService().updateMember(member);

		// 4. 받은 결과 값으로 성공 실패 패이지 전송
		
		if(result > 0){
			//수정 성공시 마이페이지 화면 출력
			// myinfo 서블릿을 구동 시킴
			// 서블릿 에서 서블릿 구동 할수 있음
			response.sendRedirect("/first/myinfo?userid="+member.getUserId());

			//수정 성공시 메인페이지 화면 출력
			// 이동하는 화면에 전달하는 값이 없다면 sendRedirect 이용 해서 이동
			//response.sendRedirect("/first/index.jsp");
		}else{
			RequestDispatcher view = request.getRequestDispatcher("veiws/common/error.jsp");
			request.setAttribute("message", member.getUserId() + "님의 회원정보 수정 실패!");
			view.forward(request, response);
	}
		}

		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
