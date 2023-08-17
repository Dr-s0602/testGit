package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class LoginAccessServlet
 */
@WebServlet("/loginok")
public class LoginAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 관리자용 로그인 접속 제한/해제 처리용 컨트롤러

		String userid = request.getParameter("userid");
		String ok = request.getParameter("ok");
		// boolean 값으로 하면 안되나 ?
		String loginok = null;
		if(ok.equals("true")){
			loginok = "Y";
		}else{
			loginok = "N";
		}
		MemberService mService = new MemberService();
		int result = mService.updateLoginOk(userid,loginok);

		// 회원전체 조회를 다시 실행해서, memberListView.jsp 에 memberList를 다시 보냄(브라우저는 새로고침됨)
		ArrayList<Member> memberList = null;
		if(result > 0){	
			memberList = mService.selectList();

		}
		
		RequestDispatcher view = null;
		if(result >0 && memberList.size() > 0){
			view = request.getRequestDispatcher("views/member/memberListView.jsp");
			request.setAttribute("memberList",memberList);
		}else{
			view = request.getRequestDispatcher("views/common/error.jsp");
			request.setAttribute("message", "회원 정보를 변경하는대 실패 했습니다. 코딩한 사람을 때리세요");
		}
		view.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
