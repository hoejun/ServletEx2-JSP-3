

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import jdk.nashorn.internal.ir.RuntimeNode.*;


@WebServlet("/LoginServletTest")
public class LoginServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServletTest() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트dml 요청 정보 한글처리
		request.setCharacterEncoding("UTF-8");
		
		//응답하는 데이터 타입이 html문서타입 지정, 응답되는 데이터들의 한글처리
		response.setContentType("text/html;cjarset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//클라이언트 페이지에서 전송되어 오는 id값과 passwd값을 String타입의 변수 값으로 가져온다.
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//아이디와 비밀번호가 java이면 인증이 되었다고 가정한다. 
		//(제대로 인증을 하려면 DB에서 값을 가져와서 비교해야 하지만 임의로 
		//"java","java"와 비교 한거임)
		if(id.equals("java") && passwd.equals("java")){
			//세션영역 객체 얻기
			HttpSession session =request.getSession();
			
			//인증이 되었을때 id라는 속성에 있는 id변수값을 세션영역 객체에 저장한다.
			session.setAttribute("id", id);
			
			/*서블릿에서 특정 페이지로 포워딩(이동) 하는 방법 1.Dispatcher방식*/
			//요청 처리 페이지를 loginSuccess.jsp페이지로 포워딩(이동) 하여..
			//로그인 성공여부 처리하기
		RequestDispatcher dispatcher=	
				request.getRequestDispatcher("loginSuccess.jsp");
			//forward()메소드를 호출하여 실제 해당 URL로 포워딩이 이루어짐
		dispatcher.forward(request, response);
		}else{//로그인이 이루어지지 않았을때 자바스크립트로..
			//"아이디나 비밀번호가 일치하지 않았습니다."라는 경고 메세지 출력 해주고
			//인증하는 페이지로 되돌아간다.
			out.println("<script>");
			
			out.println("alert('아이디나 비밀번호가 일치하지 않습니다.')");
			out.println("history.back()");
			out.println("</script>");
		
		}//doPost 메소드 끝
		
	}

}
