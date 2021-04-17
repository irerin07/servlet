package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 스프링 부트는 Servlet을 직접 등록해서 사용할 수 있도록 @ServletComponentScan을 지원한다. 최상위 패키지부터 하위 패키지들을 스캔하며 서블릿을 자동 등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}
