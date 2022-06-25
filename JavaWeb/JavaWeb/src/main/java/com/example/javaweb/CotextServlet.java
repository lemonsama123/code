package com.example.javaweb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CotextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        System.out.println(servletContext.getInitParameter("username"));
        System.out.println(servletContext.getInitParameter("password"));
        System.out.println(getServletConfig().getServletContext().getContextPath());
        System.out.println(servletContext.getRealPath("/"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
