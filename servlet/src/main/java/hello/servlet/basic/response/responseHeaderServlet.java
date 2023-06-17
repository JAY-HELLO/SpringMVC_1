package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class responseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //status-line

        //헤더의 편의 메서드
        content(resp);
        PrintWriter writer = resp.getWriter();
        //쿠키의 편의 메서드
        cookie(resp);
        writer.println("ok");

        redirect(resp);
    }

    private void content(HttpServletResponse resp) {
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setHeader("Content-Type", "text/plain; charset=utf-8");
        //캐시에 대한 것, 해당 2줄을 통해 캐시를 완전히 무효화
        resp.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
        resp.setHeader("Pragma","no-cache");

        resp.setHeader("my-header","hello");
    }

    private void cookie(HttpServletResponse response) {
        //Set-Cookie: myCookie=good; Max-Age=600;
        //response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); //600초
        response.addCookie(cookie);
    }
    private void redirect(HttpServletResponse response) throws IOException {
//Status Code 302
//Location: /basic/hello-form.html
//response.setStatus(HttpServletResponse.SC_FOUND); //302
//response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }
}
