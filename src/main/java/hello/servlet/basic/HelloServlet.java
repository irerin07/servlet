package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "heeloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        HttpServletRequest, HttpServletResponse는 둘 다 인터페이스
        Tomcat과 같은 WAS들이 서블릿 표준 스펙을 구현한다.
        req = org.apache.catalina.connector.RequestFacade@3d12152a
        resp = org.apache.catalina.connector.ResponseFacade@236f917b
        위의 두가지가 해당 스펙을 구현한 구현체들
         */

        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("resp = " + resp);

        //쿼리 파라미터를 읽어온다
        String userName = req.getParameter("username");
        System.out.println("userName = " + userName);

        //컨텐트타입과 캐릭터인코딩은 헤더정보에 들어간다.
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("Hello " + userName);
    }
}
