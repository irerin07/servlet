<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: count
  Date: 2021-04-24
  Time: 오전 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /*
    Model View Controller
    Controller: HTTP요청을 받아 Parameter를 검증하고, 비즈니스 로직을 호출한다.. 뷰에 전달할 데이터를 조회해서 모델에 담는다.
    Model: 뷰에 출력할 데이터를 담아둔다. 뷰가 필요한 데이터를 모두 모델에 담아 전달해주기 때문에 뷰는 화면을 렌더링 하는 일에만 집중할 수 있다.
    View: 모델에 담겨있는 데이터를 활용해 화면을 그리는 일에 집중한다.

    Servlet을 Controller로 사용하고 JSP를 뷰로 사용하여 MVC패턴을 적용할 수 있다.
    Model은 HttpServletRequest 객체를 사용한다. request는 내부에 데이터 저장소를 가지고 있는데 request.setAttribute(), request.getAttribute()를 사용하면 데이터를 보관하고 조회할 수 있다.
     */
    // request, response 사용 가능. JSP도 결국 Servlet으로 변환되어 사용되기 때문에 req, resp를 지원한다
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("save.jsp");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);
    System.out.println("member = " + member);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUserName()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>


