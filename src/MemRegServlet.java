

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/memReg")
public class MemRegServlet extends HttpServlet {
	//상수
	private static final long serialVersionUID = 1L;
       
    //생성자
    public MemRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답하는 데이터 타입이 html타입으로 지정함, 응답되는 데이터들의 한글처리
		response.setContentType("text/html;charset=UTF-8");
		
		//문자열 단위로 response객체에 있는 내용을 출력할 수 있는 출력 스트림을 생성하는 부분
		PrintWriter out =response.getWriter();
		
		//클라이언트가 요청한 값 전달 받아 저장
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		String hobby = request.getParameter("hobby");
		
		//저장한 값을 다시 클라이언트에게 응답하기
		out.println("이름 : " + name + "<br/>");
		out.println("주소 : " + addr + "<br/>");
		out.println("전화번호 : " + tel + "<br/>");
		out.println("취미 : " + hobby + "<br/>");
		
		
		
		
	}

}
