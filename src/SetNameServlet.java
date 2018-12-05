

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/SetName")
public class SetNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SetNameServlet() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HTTP 프로토콜의 단점
		 * -> 순서1) 첫번째 클라이언트의 요청
		 * 	    순서2) 서버에서 응답을 보낸다.
		 *    순서3) 똑같은 클라이언트가 두번째 요청보내기
		 *    순서4) 서버에서는 두번째 요청을 한 클라이언트가 첫번째요청을 한 클라이언트임을 인식 X
		 * 
		 */
		
		/*
		 * HTTP 프로토콜의 단점을 보완하기 위한 방법
		 *  -> 웹서버 측의 세션 메모리 영역 만들기
		 *  순서1) 첫번째 클라이언트가 요청
		 *  순서2) 서버의 세션메모리 영역을 만들어 세션 내부의 변수안에.. 클라이언트를 식별할수 없는 세션 아이디 저장
		 *  순서3) 서버는 첫번째 클라이언트 요청에 대한 응답값 + 클라이언트를 식별할 수 있는 세션아이디를 클라이언트 PC로 전송
		 *  순서4) 서버에서 전달 받은 세션아이디를 클라이언트 PC의 쿠키 저장소에 저장됨..
		 *  순서5) 똑같은 클라이언트가 서버에 두번째 요청보내기 + 쿠키에 저장된 세션아이이디 같이 보내기
		 *  순서6) 서버는 요청에 전송되어 오는 세션아이디를 판별하여 두번째 요청을한 클라이언트가 .... 첫번째 요청을 한 클라이언트임을 인식함.
		 *  
		 */
		
		/*서버측의 세션 영역 만들기 위한 방법
		 *  HttpServletRequest클래스의 getSession()메소드를 이용해서 얻는다.
		 *  
		 * 
		 */
		//HttpSession 인터페이스에서 제공되는 메소드를 이용하여 세션 객체영역 얻기
		HttpSession session = request.getSession();
		
		//해당 세션 객체 영역에 name이라는 이름으로 특정 값을 저장하기위해 setAttribute()메소드를 사용해서
		session.setAttribute("name", "신상국");
		
		//응답한는 데이터타입이 html문서 타입으로 지정, 응답되는 데이터들의 한글처리
		response.setContentType("text/html;charset=UTF-8");
		
		//문자열 단위로 response객체에 내용을 출력할 수 있는 출력 스트림을 생성한 부분
		PrintWriter out = response.getWriter();
		
		out.println("<h1>새로만든 세션영역에 이름 저장</h1>");
		
		
	}

}
//결론 : 세션객체는 클라이언마다 하나씩 할당되면....
//		브라우저를 종료하고 세션에서 나갈때까지는 계속해서 세션이 서버측에 유지된다는 것을 알수있다.
