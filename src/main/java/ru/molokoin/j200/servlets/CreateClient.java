package ru.molokoin.j200.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.entities.Address;
import ru.molokoin.j200.entities.Client;
import ru.molokoin.j200.services.RepositoryFace;

@WebServlet(name = "CreateClient", value = "/create-client")
public class CreateClient extends HttpServlet{
    @EJB
    public RepositoryFace repository;
    /**
     * Метод отдает страничку с формой, для заполнения сведений о клиенте
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String clientid = request.getParameter("clientid");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <title>j200 : create</title>");
        out.println("    <link href=\"layout/styles.css\" rel=\"stylesheet\"> ");
        out.println("</head>");
        out.println("<body>");
        out.println("    <aside>");
        out.println("    </aside>");
        /**
         * Если id == null ---> create
         */
        if (clientid == null) {
            out.println("    <header>");
            out.println("              <h1>Создание нового клиента</h1>");
            out.println("    </header>");
        
            out.println("    <main>");
            out.println("        <form action=\"create-client\" method=\"post\">");
            out.println("            <br>");
            out.println("            <label >Сведения о клиенте: </label>");
            out.println("            <br><br>");
            out.println("            <label>Введите ФИО клиента</label>");
            out.println("            <br>");
            out.println("            <input type=\"text\" name=\"name\" placeholder=\"Введите ФИО клиента:\">");
            out.println("            <br><br>");
            out.println("            <label>Выбор типа клиента:</label>");
            out.println("            <br>");
            out.println("            <select name=\"client_type\">");
            out.println("            <option value=\"Юридическое лицо\">Юридическое лицо</option>");
            out.println("            <option value=\"Физическое лицо\">Физическое лицо</option>");
            out.println("                </select>");
            out.println("            <br><br>");
            out.println("            <label>Дата добавления клиента:</label>");
            out.println("            <br>");
            out.println("            <input type=\"date\" name=\"added\" placeholder=\"yyyy-mm-dd\">");
            out.println("            <br><br>");
            out.println("            <button type=\"submit\" formmethod=\"post\">Сохранить</button>");
            out.println("        </form>");
            out.println("        <a href=\"view-list\">Вернуться к списку клиентов без созранения изменений</a>");
            out.println("    </main>");
        }
        /**
         * Если id != null ---> update
         */
        else{
            Client client = repository.getClientById(Integer.valueOf(clientid));
            out.println("    <header>");
            out.println("              <h1>" + "Редактор данных клиента #" + client.getId() + "</h1>");
            out.println("    </header>");
            out.println("    <aside>");
            out.println("        <form action=\"update-client\" method=\"post\">");
            out.println("            <br>");
            out.println("              <input type=\"hidden\" name=\"id\" value=\"" + client.getId() + "\">");
            out.println("            <label>ФИО клиента</label>");
            out.println("            <br>");
            out.println("              <input type=\"text\" name=\"name\" value=\"" + client.getName() + "\">");
            out.println("            <br><br>");
            out.println("            <label>Выбор типа клиента:</label>");
            out.println("            <br>");
            out.println("            <select name=\"client_type\">");
            out.println("                  <option value=\"" + client.getClient_type() + "\" selected enabled hidden>" + client.getClient_type() + "</option>");
            out.println("                <option value=\"Юридическое лицо\">Юридическое лицо</option>");
            out.println("                <option value=\"Физическое лицо\">Физическое лицо</option>");
            out.println("            </select>");
            out.println("            <br><br>");
            out.println("            <label>Дата добавления клиента:</label>");
            out.println("            <br>");
            out.println("              <input type=\"date\" name=\"added\" value=\"" + client.getAdded() + "\"" + ">");
            out.println("            <br><br>");
            out.println("            <button type=\"submit\" formmethod=\"post\">Обновить</button>");
            out.println("        </form>");
            out.println("        <br>");
            out.println("        <form action=\"add-address\" method=\"get\">");
            //кнопка : добавить адрес
            out.println("              <input type=\"hidden\" name=\"clientid\" value=\"" + client.getId() + "\">");
            out.println("            <button type=\"submit\" formmethod=\"get\">Добавить адрес</button>");
            out.println("        </form>");
            out.println("        <br>");
            out.println("        <form action=\"remove-client\" method=\"post\">");
            out.println("              <input type=\"hidden\" name=\"clientid\" value=\"" + client.getId() + "\">");
            out.println("            <button type=\"submit\" formmethod=\"post\">Удалить</button>");
            out.println("        </form>");
            out.println("        <br><br>");
            out.println("        <a href=\"view-list\">Просмотреть список клиентов</a>");
            out.println("    </aside>");

            /**
             * вывод списка адресов, привязанных к клиенту
             */
            out.println("    <main>");
            out.println("<table>");
            //Заголовки столбцов
            out.println("<tr>");
            out.println("<td>ID</td>");
            out.println("<td>IP</td>");
            out.println("<td>MAC</td>");
            out.println("<td>Модель</td>");
            out.println("<td>Адрес</td>");
            out.println("</tr>");
            //строки таблицы
            for (Address address : client.getAddresses()) {
                out.println("<tr>");
                out.println("<td>" + address.getId() +"</td>");
                out.println("<td>" + "<a href=\"add-address?addressid="+address.getId()+"\">"+ address.getIp()  +"</a></td>");
                out.println("<td>" + address.getMac() + "</td>");
                out.println("<td>" + address.getModel() + "</td>");
                out.println("<td>" + address.getAddress() + "</td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("</tr>");
            }
            out.println("    </main>");
        }
        out.println("    <footer>");
        out.println("    </footer>");
        out.println("</body>");
        out.println("</html>");        
    }

    /**
     * Метод добавляет клиента в базу
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("name");
        String client_type = request.getParameter("client_type");
        String added = request.getParameter("added");
        Client c = new Client();
        c.setName(name);
        c.setClient_type(client_type);
        c.setAdded(added);
        repository.createClient(c);
        response.sendRedirect("view-list");
    }
    
}
