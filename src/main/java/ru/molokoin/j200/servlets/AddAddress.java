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
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>j200:add-address</title>");
        out.println("    <link href=\"layout/styles.css\" rel=\"stylesheet\">");
        out.println("</head>");
        out.println("<body>");
        out.println("    <header>");
        out.println("    </header>");
        out.println("    <aside>");
        out.println("    </aside>");
        out.println("    <main>");
        out.println("    </main>");

        /**
         * Если clientid != null ---> create
         */
        if (request.getParameter("clientid") != null){
            Integer clientid = Integer.parseInt((String)request.getParameter("clientid"));
            out.println("    <header>");
                out.println("<h1>Добавление адреса для клиента id# " + clientid + "</h1>");
            out.println("    </header>");
            out.println("    <main>");
            out.println("        <form action=\"add-address\" method=\"post\">");
            // ip
            out.println("            <br><br>");
            out.println("            <label >СВЕДЕНИЯ ОБ АДРЕСАХ: </label>");
            out.println("            <br><br>");
            out.println("            <label for=\"ip\">Введите ip-адрес клиента </label>");
            out.println("            <br>");
            out.println("            <input type=\"text\" name=\"ip\" pattern=\"((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\" value=\"0.0.0.0\">");
            // mac
            out.println("            <br><br>");
            out.println("            <label>Введите mac-адрес клиента</label>");
            out.println("            <br>");
            out.println("            <input type=\"text\" name=\"mac\" pattern=\"([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})\" value=\"00:00:00:00:00:00\">");
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
            out.println("              <input type=\"hidden\" name=\"clientid\" value=\"" + clientid + "\">");
            /**
             * Кнопка сохранения:
             * - отправляет пользователя на сервлет add-address:post
             * - там данные об адресе сохраняются
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
        /**
         * Если параметр clientid == null,
         * значит параметр addressid задан в форме, работаем с ним (редактируем адрес)
         */
        if (request.getParameter("addressid") != null){
            Integer addressid = Integer.parseInt((String)request.getParameter("addressid"));
            Address address = repository.getAddressById(addressid);
            out.println("    <header>");
                out.println("<h1>Редактирование адреса для клиента id# " + repository.getAddressById(addressid).getClient().getId() + "</h1>");
            out.println("    </header>");
            out.println("    <main>");
            out.println("        <form action=\"update-address\" method=\"post\">");
            // ip
            out.println("            <br><br>");
            out.println("            <label for=\"ip\">Введите ip-адрес клиента </label>");
            out.println("            <br>");
            out.println("            <input type=\"text\" name=\"ip\" pattern=\"((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\" value=\"" + address.getIp() + "\">");
            // mac
            out.println("            <br><br>");
            out.println("            <label>Введите mac-адрес клиента</label>");
            out.println("            <br>");
            out.println("            <input type=\"text\" name=\"mac\" pattern=\"([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})\" value=\"" + address.getMac() + "\">");
            // model
            out.println("            <br><br>");
            out.println("            <label>Укажите модель устройства</label>");
            out.println("            <br>");
            out.println("            <input type=\"text\" name=\"model\" value=\"" + address.getModel() + "\">");
            // address
            out.println("            <br><br>");
            out.println("            <label>Укажите адрес клиента</label>");
            out.println("            <br>");
            out.println("            <input type=\"text\" name=\"address\"  value=\"" + address.getAddress() + "\">");
            /**
             * Передаем сведения об идентификаторе адреса в ответ, для обработки сервлетом обновления адресов update-address
             */
            out.println("              <input type=\"hidden\" name=\"addressid\" value=\"" + addressid + "\">");
            /**
             * Кнопка сохранения:
             * - отправляет пользователя на сервлет add-address:post
             * - там данные об адресе сохраняются
             * - и пользователь пересылается на сервлет редактирования сведений о пользователе create-client:get#client_id, откуда он и ушел
             * 
             */
            out.println("            <br><br>");
            out.println("            <button type=\"submit\" formmethod=\"post\">Обновить</button>");
            out.println("        </form>");

            /**
             * Удаление адреса
             */
            out.println("        <form action=\"remove-address\" method=\"post\">");
            out.println("              <input type=\"hidden\" name=\"addressid\" value=\"" + addressid + "\">");
            out.println("            <br>");
            out.println("            <button type=\"submit\" formmethod=\"post\">Удалить</button>");
            out.println("    </main>");
            out.println("    <footer>");
            out.println("    </footer>");
            out.println("</body>");
            out.println("</html>");
        }
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