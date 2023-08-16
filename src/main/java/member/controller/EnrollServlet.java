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
		//member.setUserPwd(request.getParameter("userpwd"));
		String userPwd = request.getParameter("userpwd"); //암호화 처리를 위해 변수에 저장함
		member.setUserName(request.getParameter("username"));
		member.setGender(request.getParameter("gender"));
		member.setAge(Integer.parseInt(request.getParameter("userage")));
		member.setEmail(request.getParameter("email"));
		member.setPhone(request.getParameter("phone"));
		
		
		//checkbox 전송형태 :
		//....&hobby=간&hobby=신장.....
		// 같은 이름의 값이 여러개 전송온 경우 getParameter("이름") 사용하면 에러남
		// getparameterValues("이름") : 리턴타입 String[] 사용함
		// String[] hobbies = request.getParameterValues("hobby");
		// System.out.println("hobbies.length" + hobbies.length);
		//문자열 배열을 하나의 String 으로 변환 한다면(구분자를 ,로 정한 경우)
		// String hobby = String.join(",", hobbies);
		// System.out.println("hobby : " + hobby);
		
//		//textarea
//		String ect = request.getParameter("etc");
//		System.out.println(ect);
		
		//웹에서는 암호화 알고리즘 사용시 단방향 알고리즘만 사용함 : SHA-512
		// 단뱡향 알고리즘은 복호화 알고리즘이 없음
		//java.security.MessageDigest 클래스 이용함
		
		String cryptoUserpwd = null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			//패스워드 문자열을 암호문으로 바꾸려면, byte[]로 변환해야 함
			
			byte[] pwdValues = userPwd.getBytes(Charset.forName("UTF-8"));
			// 암호문으로 바꾸기
			
			md.update(pwdValues);
			//암호화된 byte[] 을 String  으로 바꿈 : 암호문 상태임
			cryptoUserpwd = Base64.getEncoder().encodeToString(pwdValues);
			
			//확인 
			System.out.println("암호화된 패스워드 : "+cryptoUserpwd);
			System.out.println("암호화된 패스워드 길이 : "+cryptoUserpwd.length());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		member.setUserPwd(cryptoUserpwd);
		
		// 3. 모델의 서비스 메소드로 값 전달 실행하고 결과 받기
		int result = new MemberService().insertMember(member);
		// 4. 받은 결과로 성공 또는 실패 페이지 내보내기
		
		//result = 0;
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
