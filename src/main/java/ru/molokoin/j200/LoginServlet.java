package ru.molokoin.j200;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "POST : login-servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        


        String login = request.getParameter("login");
        String password = request.getParameter("password");

        out.println("<html><body>");
        out.println("<h1>" + "login :"  + login + "</h1>");
        out.println("<h1>" + "password :"  + password + "</h1>");
        out.println("</body></html>");


        // boolean resCheckUser = new UserStore().checkUser(login, password);
        // if(resCheckUser){
        //     getServletContext().getRequestDispatcher("/ServletViewList").forward(request, response);
        // } else {
        //     request.setAttribute("message", "Логин или пароль не найдены!");
        //     getServletContext().getRequestDispatcher("/ErrorServlet").forward(request, response);
        // }

    }

    public void destroy() {
    }
}