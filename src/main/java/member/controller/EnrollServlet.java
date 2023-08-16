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
 * Servlet implementation class EnrollServlet
 */
@WebServlet("/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입 처리용 컨트롤러
		System.out.println("하이");
		// 1. 전송온 값에 한글이 있다면 인코딩처리함
		request.setCharacterEncoding("UTF-8"); //전송보낸 뷰페이지의 문자셋(charset)을 값으로 사용함
		// 2. 전송온 값 꺼내서 변수 또는 객체에 옮겨 저장하기
		Member member = new Member(); //모델 서비스로 보낼 값의 갯수가 1개 이상이면 객체에 저장

		member.setUserId(request.getParameter("userid"));
		member.setUserPwd(request.getParameter("userpwd"));
		member.setUserName(request.getParameter("username"));
		member.setGender(request.getParameter("gender"));
		member.setAge(Integer.parseInt(request.getParameter("userage")));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));

		
		// 3. 모델의 서비스 메소드로 값 전달 실행하고 결과 받기
		int result = new MemberService().insertMember(member);
		// 4. 받은 결과로 성공 또는 실패 페이지 내보내기
		if(result > 0){
			//회원 가입이 성공 했을때
			response.sendRedirect("/first/views/member/loginPage.html");
		}else{
			// 회원 가입이 실패 했을때 error.jsp 페이지 내보내기 에러메세지를 보냄
			RequestDispatcher view = request.getRequestDispatcher("views/common/error.jsp");
			// 상대 경로만 사용 가능
			
			//지정한 뷰로 내보낼 정보나 객체가 있으면 request 에 기록 저장함
			// request.setAttribute(String name, Object value);
			request.setAttribute("message", "회원 가입 fail");

			// view.forward()
			// 뷰를 포워딩함
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
