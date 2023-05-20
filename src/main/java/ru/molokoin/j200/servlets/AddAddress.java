package ru.molokoin.j200.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.entities.Address;
import ru.molokoin.j200.services.RepositoryFace;

@WebServlet(name = "AddAddress", value = "/add-address")
public class AddAddress extends HttpServlet{
    @EJB
    private RepositoryFace repository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Integer addressid = Integer.parseInt((String)request.getParameter("addressid"));
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>j200:add-address</title>");
        // out.println("    <link href=\"layout/styles.css\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        out.println("    <header>");
        out.println("    </header>");
        out.println("    <aside>");
        out.println("    </aside>");
        out.println("    <main>");
        out.println("    </main>");

        /**
         * Если id == null ---> create
         */
        out.println("    <main>");
        out.println("        <form action=\"add-address\" method=\"post\">");
        // ip
        out.println("            <br><br>");
        out.println("            <label >СВЕДЕНИЯ ОБ АДРЕСАХ: </label>");
        out.println("            <br><br>");
        out.println("            <label for=\"ip\">Введите ip-адрес клиента </label>");
        out.println("            <br>");
        out.println("            <input type=\"text\" name=\"ip\" value=\"0.0.0.0\">");
        // mac
        out.println("            <br><br>");
        out.println("            <label>Введите mac-адрес клиента</label>");
        out.println("            <br>");
        out.println("            <input type=\"text\" name=\"mac\" placeholder=\"00:00:00:00:00:00:00:00\">");
        // model
        out.println("            <br><br>");
        out.println("            <label>Укажите модель устройства</label>");
        out.println("            <br>");
        out.println("            <input type=\"text\" name=\"model\">");
        // address
        out.println("            <br><br>");
        out.println("            <label>Укажите адрес клиента</label>");
        out.println("            <br>");
        out.println("            <input type=\"text\" name=\"address\">");
        /**
         * Передаем сведения о клиенте в ответ
         */
        out.println("              <input type=\"hidden\" name=\"clientid\" value=\"" + repository.getAddressById(addressid).getClient().getId() + "\">");
        /**
         * Кнопка сохранения:
         * - отправляет пользователя на сервлет add-address:post
         * - там данные об адресе созраняются
         * - и пользователь пересылается на сервлет редактирования сведений о пользователе create-client:get#client_id, откуда он и ушел
         * 
         */
        out.println("            <br><br>");
        out.println("            <button type=\"submit\" formmethod=\"post\">Сохранить</button>");
        out.println("        </form>");
        out.println("    </main>");
        out.println("    <footer>");
        out.println("    </footer>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Integer clientid = Integer.parseInt((String)request.getParameter("clientid"));
        Address address = new Address();
        address.setIp(request.getParameter("ip"));
        address.setMac(request.getParameter("mac"));
        address.setModel(request.getParameter("model"));
        address.setAddress(request.getParameter("address"));
        address.setClient(repository.getClientById(clientid));
        repository.createAddress(address);
        response.sendRedirect("create-client?clientid=" + clientid);
    }
}