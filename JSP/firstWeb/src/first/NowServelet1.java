package first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1. 서블릿 클래스 만들기 위해서는 HttpServlet 클래스를 반드시 상속해야한다.
public class NowServelet1 extends HttpServlet {

	// 2. 요청에 맞는 처리를 위한 메서드를 선택, 오버라이딩해야한다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
		
		// 응답처리 : HTML 문서를 만든다.
		
		resp.setContentType("text/html; charset=EUC_KR");
		
		PrintWriter out = resp.getWriter();
		out.println("<HTML><HEAD><TITLE>TEST</TITLE></HEAD>");
		out.println("<BODY><H2>TEST </H2>");
		out.println("오늘의 날짜와 시간은 : " + new java.util.Date());
		out.println("</BODY></HTML>"); 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		doGet(req,resp);
		
	}
	
	


}
