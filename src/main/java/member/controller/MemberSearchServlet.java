package member.controller;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/msearch")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberSearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 관리자용 회원관리 서비스에서 회원검색 처리용 컨트롤러

		// 1. 한글 있으면 인코딩
		request.setCharacterEncoding("UTF-8");
		// 2. 전송온 값 객체에 저장
		String action = request.getParameter("action");
		String keyword = null, begin = null, end = null;
		if (action.equals("enrolldate")) {
			begin = request.getParameter("begin");
			end = request.getParameter("end");
		} else {
			keyword = request.getParameter("keyword");
		}
		// 3. 저장한 값 처리(모델서비스) 해서 반환값 받기
		MemberService memberService = new MemberService();
		ArrayList<Member> memberList = null;
		switch (action) {
			case "id":
				memberList = memberService.selectSearchUserId(keyword);
				break;
			case "gender":
				memberList = memberService.selectSearchGender(keyword);
				break;
			case "age":
				memberList = memberService.selectSearchAge(keyword);
				break;
			case "enrolldate":
				memberList = memberService.selectSearchEnrollDate(Date.valueOf(begin), Date.valueOf(end));
				break;
			case "loginok":
				memberList = memberService.selectSearchLoginOk(keyword);
				break;
		}
		// 4. 받은 결과로 처리 패이지 선택해서 내보내기 
		RequestDispatcher view = null;
		if(memberList.size() > 0){
			view = request.getRequestDispatcher("views/member/memberListView.jsp");
			request.setAttribute("memberList",memberList);
		}else{
			view = request.getRequestDispatcher("views/common/error.jsp");
			if(keyword != null){
				request.setAttribute("message",
				action + " 검색에 대한 " + keyword + "결과가 존재하지 않습니다.");
			}else{
				request.setAttribute("message",
				action + "검색에 대한 " + begin + " 부터" + end + "사이에 가입한 회원이 존재하지 않습니다.");
			}
		}
		view.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
