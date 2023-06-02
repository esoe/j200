package ru.molokoin.j200.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ru.molokoin.j200.entities.Account;
import ru.molokoin.j200.services.AccessFace;

@WebServlet(name = "CheckAccess", value = "/check-access")
public class CheckAccess extends HttpServlet{
    @EJB
    private AccessFace access;

    /**Выводим список зарегистрированных аккаунтов */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Account> accounts = access.getAccounts();
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>j200:check-access</title>");
        //out.println("    <link href=\"layout/styles.css\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        out.println("    <header>");
        out.println("    </header>");
        out.println("    <aside>");
        out.println("    </aside>");
        out.println("    <main>");
        //выводим данные из таблицы Access.Accounts
        for (Account account:accounts){
            out.println("<p>" + account.toString() + "</p>");
        }
        out.println("    <a href=\"index.html\">Перейти авторизации</a>");
        out.println("    </main>");
        out.println("    <footer>");
        out.println("    </footer>");
        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Проверяем отправленные пользователем учетные данные.
     * - в случае успешной проверки, отправляем его на страницу (view-list)
     * - в случае указания пользователем отсутствующих в базе данных, предлагаем создать аккаунт (create-account)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (access.check(login, password)){
            response.sendRedirect("view-list");
        }else{
            response.sendRedirect("create-account");
        }
    }
}
