package hello.servlet.web.frontcontroller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyView {
	
	private String viewPath;
	
	public MyView(String viewPath) {
		this.viewPath = viewPath;
	}

	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트로부터 최초에 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 넘기는(보내는) 역할을 수행하거나, 특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 클래스
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

	public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		modelToRequestAttribute(model, request);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
		
	}

	private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
		//model 객체 다 꺼내서 전달하기
		model.forEach((key, value) -> request.setAttribute(key, value));
	}
	
}
