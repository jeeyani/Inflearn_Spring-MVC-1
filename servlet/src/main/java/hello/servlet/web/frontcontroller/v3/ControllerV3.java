package hello.servlet.web.frontcontroller.v3;

import java.util.Map;

import hello.servlet.web.frontcontroller.ModelView;

public interface ControllerV3 {

	ModelView process(Map<String, String> paramMap); //servlet에 종속적이지 않게 만들기
	
}
