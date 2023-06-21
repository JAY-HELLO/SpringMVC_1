<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: Double_J
  Date: 2023-06-19
  Time: 오후 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();

    //request, response 는 jsp 서블릿에서 문법으로 기본적으로 적용되서 그냥 사용하면 된다
    //기존의 req를 request로 바꾼 것도 그 이유이다.
    System.out.println("MemverSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id = <%= member.getId()%></li>
    <li>username = <%= member.getId()%></li>
    <li>age = <%= member.getId()%></li>

</ul>
<a href="/index.html">메인</a>
</body>
</html>
