

import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//어노테이션 : 
/*
 * java 5.0부터 지현되는 기술로, 기존 설정파일(web.xml)에서 제공하는 설정 내용을 
 * web.xml 파일에서 설정하지 않아도 해당 소스 내에 설정할 수 있는 방법을 제공함으로써
 * 설정파일의 크기를 줄이거나 설정파일 자체를 없앨 수 있는 역할을 하는 기호
 */


//http://localhost:8088/JspProject/login으로 요청이 전송되어오면
//해당 서블릿 클래스에서 요청을 처리하겠다는 의미임.

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 폼에서 전송되어 오는 id라는 이름의 파라미터 값과
		//passwd라는 파라미터 값을 받는 부분
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//응답하는 데이터 타입이 html문서 타입으로 지정함.
		//응답되는 데이터들의 한글처리
		response.setContentType("text/html;charset=UTF-8");
		
		//문자열 단위로 response 객체에 내용을 출력할 수 있는 출력 스트림을 생성한 부분
		PrintWriter out = response.getWriter();
		//클라이언트에게 응답(메시지 id변수 값과 passwd변수 값을 출력하는 부분)
		out.println("아이디=" + id + "<br/>");
		out.println("비밀번호=" + id + "<br/>");
		
		
	}//doGet

	
}


