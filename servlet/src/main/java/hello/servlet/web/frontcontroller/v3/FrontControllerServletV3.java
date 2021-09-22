package hello.servlet.web.frontcontroller.v3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet{
	
	private Map<String, ControllerV3> controllerMap = new HashMap<>();

	public FrontControllerServletV3() {
		//경로 매핑시키기
		controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		///frontcontroller/v3/members
		String requestURI = request.getRequestURI();
		
		ControllerV3 controller = controllerMap.get(requestURI);
		
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND); //404 에러
			return;
		}
		
		//controller.process(request, response);
		/*MyView view = controller.process(request, response);
		view.render(request, response);*/

		//paramMap
		Map<String, String> paramMap = createParamMap(request);
		
		ModelView mv = controller.process(paramMap);
		String viewName = mv.getViewName(); //논리이름 가져오기
		
		MyView view = viewResolver(viewName); 
		
		//뷰 객체를 통해서 HTML 화면을 렌더링
		view.render(mv.getModel(),request, response); //model도 함께 넘겨주기
	}

	private MyView viewResolver(String viewName) {
		
		return new MyView("/WEB-INF/views/"+viewName+".jsp");
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<String, String>();
		
		//파라미터 이름 모두 가져오기
		request.getParameterNames().asIterator()
				.forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		
		return paramMap;
	}
}
