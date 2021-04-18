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

        /*
        HttpServletRequest의 열할
        서블릿은 개발자가 직접 Http 요청 메세지를 파싱해서 사용하지 않도록 대신하여 Http 요청 메세지를 파싱하고,
        그 결과를 HttpServletRequest 객체에 담아 제공한다.
         */
        /*
        그 외에도 setAttribute 같은 여러가지 부가기능을 제공
        - request.setAttribute(name, value);
        - 해당 Http 요청이 시작부터 끝날 때까지 유지되는 임시 저장소 기능

        세션 관리 기능

        HttpServletRequest, HttpServletResponse를 사용할 때 가장 중요한 점은 이 객체들이 HTTP 요청 메세지, HTTP 응답 메세지를 편리하게 사용하도록 도와주는 객체라는 것
        따라서 이 기능에 대해 깊이있는 이해를 하려면 Http 스펙이 제공하는 요청 ,응답 메세지 자체를 이해해야 한다.
         */
    }
}
