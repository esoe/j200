package ru.molokoin.j200.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.entities.Account;
import ru.molokoin.j200.services.AccessFace;

@WebServlet(name = "CreateAccount", value = "/create-account")
public class CreateAccount extends HttpServlet{
    @EJB
    public AccessFace access;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>j200-create account</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <header>");
        out.println("        <h1>Создание учетной записи</h1>");
        out.println("    </header>");
        out.println("    <main>");
        out.println("        <form action=\"create-account\" method=\"post\">");
        out.println("            <input type=\"text\" name=\"login\" placeholder=\"login\">");
        out.println("            <br>");
        out.println("            <input type=\"password\" name=\"password\" placeholder=\"password\">");
        out.println("            <br>");
        out.println("            <input type=\"password\" name=\"confermed\" placeholder=\"conferm password\">");
        out.println("            <br><br>");
        out.println("            <button type=\"submit\" formmethod=\"post\">Создать учетную запись</button>");
        out.println("        </form>");
        out.println("    </main>");
        out.println("</body>");
        out.println("</html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confermed = request.getParameter("confermed");
        
        if (password.equals(confermed)){
            Account account = new Account();
            account.setLogin(login);
            account.setPassword(password);
            access.createAccount(account);
            response.sendRedirect("check-access");
        }
        else{
            response.sendRedirect("index.html");
            
        }
    }

    
}
