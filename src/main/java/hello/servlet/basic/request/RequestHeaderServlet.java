package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
    }

    private void printStartLine(HttpServletRequest req) {
        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("request.getMethod() = " + req.getMethod()); //GET
        System.out.println("request.getProtocal() = " + req.getProtocol()); //HTTP/1.1
        System.out.println("request.getScheme() = " + req.getScheme()); //http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + req.getRequestURL());
        // /request-test
        System.out.println("request.getRequestURI() = " + req.getRequestURI());
        //username=hi
        System.out.println("request.getQueryString() = " + req.getQueryString());
        System.out.println("request.isSecure() = " + req.isSecure()); //https 사용 유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest request){
        System.out.println("--- Headers Start---");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println("headerName = " + headerName);
        }

        System.out.println("--- Headers -end---");
        System.out.println();
    }
}
