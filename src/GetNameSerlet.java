

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/GetName")
public class GetNameSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetNameSerlet() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//해당 클라이언트에서 요청한 세션영역이 서버측에 할당되어 있으면,....
		///기존에 생성되어 있는 세션영역의 객체를 반환하고, 생성되어 있지 않으면?(첫번째 요청이면)
		//새롭게 세션 객체를 생성하는 메소드
	HttpSession session=request.getSession(true);
	
	//세션영역에 존재하는 name속성값을 반환하기위해 메소드 호출
	String name = (String)session.getAttribute("name");
	//getAttribute메소드의 리턴타입이 String아니고...
	//Object타입이므로 String 형태의 변수에 저장하기 위해서 캐스팅함
	
	//응답하는 데이터 타입이 html문서타입으로 지정, 응답되는 데이터들의 한글 처리
	response.setContentType("text/html;charset=UTF-8");
	
	//문자열 단위로 response객체에 내용을 출력할 수 있는 출력 스트림을 생성한 부분
			PrintWriter out = response.getWriter();
			
			out.println("<h1>name=" + name + "</h1>");
	}

}
//결론 : 세션객체는 클라이언마다 하나씩 할당되면...
//		브라우저를 종료하고 세션에서 나갈떄까지는 계속해서 세션이 서버측에 유지된다는 것을 알수있다.
