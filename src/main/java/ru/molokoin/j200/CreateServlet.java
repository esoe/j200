package ru.molokoin.j200;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "CreateServlet", value = "/create-servlet")
public class CreateServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        page(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        page(request, response);
    }
    /**
     * Метод формирует графический интерфейс для работы с данными клиентов
     * @param request
     * @param response
     * @throws IOException
     */
    private void page(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
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
        out.println("<body>");
        out.println("    <header>");
        out.println("        <a href=\"content/Лабораторная_работа_по_курсу_DEV_J200.pdf\">");
        out.println("            <h1>J200 : разработка корпоративных приложений</h1>");
        out.println("        </a>");
        out.println("    </header>");
        /**
         * TODO : предусмотреть условие, для отображения только одной из секций <aside>
         */
        //открываем <aside>
        out.println("    <aside>");
        out.println("        <form action=\"create-servlet\" method=\"post\">");
        // формируем секцию <aside>, для заполнения сведений о клиенте
        out.println(client(request, response));
        // формируем секцию <aside>, для внесения сведений об адресах клиента
        out.println(address(request, response));
        //закрываем <aside>
        out.println("        </form>");
        out.println("    </aside>");
        // Формируем секцию <main>, для отображения внесенных сведений о текущем клиента
        out.println(report(request, response));

        out.println("    <footer></footer>");
        out.println("</body>");
        out.println("</html>");
    }
    /**
     * Метод формирует секцию <aside> стараницы, для внесения сведений о клиенте.
     * Когда сведения о клиенте внесены при нажатии кнопки "добавить адреса"
     * - открывается панель main
     * - открывается кнопка "Зарегистрировать" (отправить данные на сервер возможно только когда заполнены все поля формы, и заполнены правильно)
     * @return
     */
    private String client(HttpServletRequest request, HttpServletResponse response){
        StringBuilder client = new StringBuilder();
        client.append("            <br>");
        client.append("            <label >СВЕДЕНИЯ О КЛИЕНТЕ:</label>");
        //client_id
        client.append("            <br><br>");
        client.append("            <label for=\"client_id\">ID клиента: </label>");
        client.append("            <br>");
        client.append("            <input type=\"text\" name=\"client_id\" value=\"1\" readonly>");
        client.append("            <br><br>");
        //client_name
        client.append("            <label>Введите ФИО клиента</label>");
        client.append("            <br>");
        client.append("            <input type=\"text\" name=\"client_name\" placeholder=\"Введите ФИО клиента\">");
        client.append("            <br><br>");
        //type
        client.append("            <label>Выбор типа клиента</label>");
        client.append("            <br>");
        client.append("            <select name=\"type\">");
        client.append("                <option value=\"Юридическое лицо\">Юридическое лицо</option>");
        client.append("                <option value=\"Физическое лицо\">Физическое лицо</option>");
        client.append("            </select>");
        client.append("            <br><br>");
        //date
        client.append("            <label>Дата добавления клиента</label>");
        client.append("            <input type=\"date\" name=\"added\">");
        return client.toString();
    }
    /**
     * Метод формирует представление (графический интерфейс) для ввода сведений об адресах клиента
     * - при нажатии кнопки "добавить адрес", происходит проверка введенных пользователем данных, в случае валидности данных,
     * данные уходят в базу (пока в куки), отображаются завершенным списком и доривсовывается пустая форма ввода нового адреса.
     * TODO : переписать секцию, для данных об адресе
     * @param request
     * @param response
     * @return
     */
    private String address(HttpServletRequest request, HttpServletResponse response){
        StringBuilder address = new StringBuilder();
        // ip
        address.append("            <br><br>");
        address.append("            <label >СВЕДЕНИЯ ОБ АДРЕСАХ: </label>");
        address.append("            <br><br>");
        address.append("            <label for=\"ip\">Введите ip-адрес клиента </label>");
        address.append("            <br>");
        address.append("            <input type=\"text\" name=\"ip\" value=\"0.0.0.0\">");
        // mac
        address.append("            <br><br>");
        address.append("            <label>Введите mac-адрес клиента</label>");
        address.append("            <br>");
        address.append("            <input type=\"text\" name=\"client_name\" placeholder=\"00:00:00:00:00:00:00:00\">");
        // model
        address.append("            <br><br>");
        address.append("            <label>Укажите модель устройства</label>");
        address.append("            <br>");
        address.append("            <input type=\"text\" name=\"model\">");
        // address
        address.append("            <br><br>");
        address.append("            <label>Укажите адрес клиента</label>");
        address.append("            <br>");
        address.append("            <input type=\"text\" name=\"address\">");
        // 
        /**
         * Кнопка добавления дополнительного адреса
         * При клике:
         * - проверяется корректность введенных данных
         * - в случае ошибок, в секции <main> указывается характер несоответствий
         * - в случае корректности данных, в секции <main> отражаются введенные данные о текущем клиенте и очищается поле ввода данных об адресах.
         */
        address.append("            <br><br>");
        address.append("            <button type=\"submit\" formmethod=\"post\">Добавить адрес</button>");
        /**
         * Кнопка сохранения данных о клиенте.
         * При клике:
         * 
         */
        address.append("            <br><br>");
        address.append("            <button type=\"submit\" formmethod=\"post\">Просмотреть данные о клиенте</button>");
        address.append("            <button type=\"submit\" formmethod=\"post\">Сохранить данные о клиенте</button>");
        return address.toString();
    }
    
    /**
     * Метод формирует секцию <main>, для отображения внесенных сведений о текущем клиента
     * @param request
     * @param response
     * @return
     */
    private String report(HttpServletRequest request, HttpServletResponse response){
        StringBuilder report = new StringBuilder();
        String client_id = request.getParameter("client_id");
        String client_name = request.getParameter("client_name");
        String type = request.getParameter("type");
        String date = request.getParameter("added");
        report.append("    <main>");
        report.append("        <h1>Карточка клиента:</h1>");
        report.append("        <p>"+ client_id +"</p>"); 
        report.append("        <p>"+ client_name +"</p>");
        report.append("        <p>"+ type +"</p>");
        report.append("        <p>"+ date +"</p>");
        report.append("    </main>");
        return report.toString();

    }
}
