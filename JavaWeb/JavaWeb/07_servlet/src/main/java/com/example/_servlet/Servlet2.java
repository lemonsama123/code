package com.example._servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);

        System.out.println(request.getAttribute("key"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
