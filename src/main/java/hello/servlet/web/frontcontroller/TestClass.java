package hello.servlet.web.frontcontroller;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExecutionChain;

import javax.servlet.http.HttpServletRequest;

public interface TestClass {

    public String test1 = "test1";
    String test2 = "test2";
    static String test3 = "test3";

    default int intTester(){
        return 0;
    }

    default int intTester2(){
        return 2;
    }

    MyView getMyView();

}
