package hello.servlet.web.frontcontroller.v3.controller;

import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

public class MemberFormControllerV3 implements ControllerV3{

	@Override
	public ModelView process(Map<String, String> paramMap) {
		
		return new ModelView("new-form");
	}

	/*@Override
	public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return new MyView("/WEB-INF/views/new-form.jsp");
		
	}*/

}
