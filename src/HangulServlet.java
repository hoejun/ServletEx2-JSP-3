

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hangul")
public class HangulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HangulServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//추가
		request.setCharacterEncoding("UTF-8");
		
		//클라이언트로 부터 요청받은 이름 전달받아 저장
		String name = request.getParameter("name");
		
		//파라미터로 받은 이름 값을 한글처리 하기 위해서 HangulUtil클래스의 toKor메소드 호출
		//toKor메소드 호출후 한글처리한 값을 반환값으로 리턴받아 저장
		String korName = name;
	
		//응답하는 데이터 타입이 html타입으로 지정, 응답되는 데이터들의 한글처리
		response.setContentType("text/html;charset=utf-8");
	
		//문자열 단위로 response객체에 내용을 출력할 수 있는 출력 스트림을 생성한 부분
		PrintWriter out = response.getWriter();
		
		//한글 처리하기 전의 값을 출력하면 한글이 깨지는 것을 확인 함.
		out.println("한글 처리전:"+ name);
		
		//한글 처리한 후에 변수 값을 출력하면 한글이 제대로 출력 되는 것을 확인함.
		out.println("한글 처리후:"+ korName);
		
		
		
		
	}

}
