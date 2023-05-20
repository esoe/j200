package ru.molokoin.j200.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.entities.Address;
import ru.molokoin.j200.entities.Client;
import ru.molokoin.j200.services.RepositoryFace;

@WebServlet(name = "ViewList", value = "/view-list")
public class ViewList extends HttpServlet{
    @EJB
    private RepositoryFace repository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        page(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        page(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws IOException
     */
    private void page(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>j200:view-list</title>");
        // out.println("    <link href=\"layout/styles.css\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<html><body >");
        out.println("<aside>");

        //Кнопка перехода на страницу создания записи о клиенте
        out.println("<form action=\"create-client\" method=\"get\">");
        out.println("    <br><br>");
        out.println("    <button type=\"submit\" formmethod=\"get\">create-client</button>");
        out.println("</form>");
        out.println("</aside>");
        out.println("<main>");
        //Вывод записей из таблицы molokoin.ru:3306/j200/Clients
        out.println("<h1>" + "Все клиенты" + "</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>ID</td>");
        out.println("<td>ФИО</td>");
        out.println("<td>Тип клиента</td>");
        out.println("<td>Дата добавления</td>");
        // out.println("<td>IP</td>");
        // out.println("<td>MAC</td>");
        // out.println("<td>Модель</td>");
        // out.println("<td>Адрес</td>");
        out.println("</tr>");
        Collection<Client> clients = repository.getClients();
        for(Client client : clients) {
                out.println("<tr>");
                out.println("<td>" + client.getId() +"</td>");
                
                out.println("<td>" + "<a href=\"create-client?clientid="+client.getId()+"\">"+ client.getName()  +"</a></td>");
                out.println("<td>" + client.getClient_type() + "</td>");
                out.println("<td>" + client.getAdded() + "</td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("</tr>");
        }
        out.println("</table>");
        out.println("</main>");
        out.println("</body></html>");
    }
    
}
