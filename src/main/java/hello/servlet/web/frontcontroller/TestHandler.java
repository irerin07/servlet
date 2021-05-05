package hello.servlet.web.frontcontroller;

import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

public class TestHandler implements TestClass{

    @Override
    public int intTester() {

        return TestClass.super.intTester();
    }

    @Override
    public int intTester2() {
        return TestClass.super.intTester2();
    }

    @Override
    public MyView getMyView() {
        return null;
    }
}
