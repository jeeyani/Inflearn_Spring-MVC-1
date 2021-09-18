package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;


@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ServletInputStream inputStream = request.getInputStream(); //바이트 코드로 바로 얻기
		String messageBody = StreamUtils.copyToString(inputStream,StandardCharsets.UTF_8); //UTF-8 인코딩 하기
		
		System.out.println("messageBody = " + messageBody);
		
		HelloData helloDate = objectMapper.readValue(messageBody, HelloData.class);
		System.out.println("helloDate.Username = " + helloDate.getUsername());
		System.out.println("helloDate.age = " + helloDate.getAge());
		
	}
	
}
