package ru.molokoin.j200.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.models.Address;
import ru.molokoin.j200.models.Client;
import ru.molokoin.j200.services.ClientService;

@WebServlet(name = "ViewList", value = "/view-list")
public class ViewList extends HttpServlet{
    @EJB
    private ClientService clientService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        page(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        page(request, response);
    }

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
        out.println("    <title>j200</title>");
        out.println("    <link href=\"layout/styles.css\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<html><body >");
        //aside
        out.println("<aside>");
        out.println("<form action=\"create\" method=\"get\">");
        out.println("    <br><br>");
        out.println("    <button type=\"submit\" formmethod=\"get\">create</button>");
        out.println("</form>");
        out.println("<form action=\"update\" method=\"get\">");
        out.println("    <br><br>");
        out.println("    <button type=\"submit\" formmethod=\"get\">update</button>");
        out.println("</form>");
        out.println("<form action=\"delete\" method=\"get\">");
        out.println("    <br><br>");
        out.println("    <button type=\"submit\" formmethod=\"get\">delete</button>");
        out.println("</form>");
        out.println("</aside>");
        //main
        out.println("<main>");
        out.println("<h1>" + "Все клиенты" + "</h1>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>ID</td>");
        out.println("<td>ФИО</td>");
        out.println("<td>Тип клиента</td>");
        out.println("<td>Дата добавления</td>");
        out.println("<td>IP</td>");
        out.println("<td>MAC</td>");
        out.println("<td>Модель</td>");
        out.println("<td>Адрес</td>");
        out.println("</tr>");

        List<Client> clients = clientService.getAllClients();
        for(Client client : clients) {
            List<Address> addresses = client.getAddresses();
            if(addresses!=null && !addresses.isEmpty()) {
                for(Address address : addresses) {
                    out.println("<tr>");
                    out.println("<td>" + client.getClientid() + "</td>");
                    out.println("<td>" + String.valueOf(client.getClient_name()) + "</td>");
                    out.println("<td>" + String.valueOf(client.getType()) + "</td>");
                    out.println("<td>" + client.getAdded() + "</td>");
                    out.println("<td>" + String.valueOf(address.getIp()) + "</td>");
                    out.println("<td>" + String.valueOf(address.getMac()) + "</td>");
                    out.println("<td>" + String.valueOf(address.getModel()) + "</td>");
                    out.println("<td>" + String.valueOf(address.getAddress()) + "</td>");
                    out.println("</tr>");
                }
            }else {
                out.println("<tr>");
                out.println("<td>" + client.getClientid() + "</td>");
                out.println("<td>" + client.getClient_name().toString() + "</td>");
                out.println("<td>" + client.getType().toString() + "</td>");
                out.println("<td>" + client.getAdded() + "</td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("</tr>");
            }
        }

        out.println("</table>");
        out.println("</main>");
        out.println("</body></html>");
    }
    
}
