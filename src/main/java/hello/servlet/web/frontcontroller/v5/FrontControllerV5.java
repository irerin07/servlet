package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.TestHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerV5 extends HttpServlet{

    //생성자 주입시에 final은 왜 붙이나?
    private final Map<String, Object> handlerMappingMap;
    private final List<MyHandlerAdapter> handlerAdapters;


    public FrontControllerV5(Map<String, Object> handlerMappingMap, List<MyHandlerAdapter> handlerAdapters){
        this.handlerMappingMap = handlerMappingMap;
        this.handlerAdapters = handlerAdapters;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object handler = getHandler(req);
        MyHandlerAdapter myHandlerAdapter;

        if(handler == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter handlerAdapter = getHandlerAdapter(handler);

        ModelView handle = handlerAdapter.handle(req, resp, handler);

        String viewName = handle.getViewName();
        MyView myView = viewResolver(viewName);

        myView.render(handle.getModel(), req, resp);

    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        for (MyHandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.supports(handler)){
                return handlerAdapter;
            }
        }
        throw new IllegalArgumentException("handler adapter not found for handler - " + handler);
    }

    private Object getHandler(HttpServletRequest req) {
        String requestUri = req.getRequestURI();
        return handlerMappingMap.get(requestUri);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
