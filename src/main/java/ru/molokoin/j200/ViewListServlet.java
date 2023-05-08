package ru.molokoin.j200;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.model.Address;
import ru.molokoin.j200.model.Client;
import ru.molokoin.j200.services.ClientService;

@WebServlet(name = "ViewListServlet", value = "/ViewListServlet")
public class ViewListServlet extends HttpServlet{
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
        out.println("<html><body align=\"center\">");
        out.println("<h1>" + "Все клиенты" + "</h1>");
        out.println("<table align=\"center\" border=\"1\" cellpadding=\"5\">");
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
        out.println("</body></html>");
    }
    
}
