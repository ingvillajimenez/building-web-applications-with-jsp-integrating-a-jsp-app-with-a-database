package com.skillsoft;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/signin")
public class SignInServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String username = request.getParameter("uname");

        request.setAttribute("username", "request_" + username);

        HttpSession session = request.getSession(false);
        session.setAttribute("username", "session_" + username);

        ServletContext ctx = getServletContext();
        ctx.setAttribute("username", "servletcontext_" + username);

        try {
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/signinconfirm.jsp");
            rd.forward(request, response);
        }
        catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
