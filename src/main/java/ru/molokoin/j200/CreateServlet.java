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
    private void page(HttpServletRequest request, HttpServletResponse response) throws IOException{
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
        out.println("<body>");
        out.println("    <header>");
        out.println("        <a href=\"content/Лабораторная_работа_по_курсу_DEV_J200.pdf\">");
        out.println("            <h1>J200 : разработка корпоративных приложений</h1>");
        out.println("        </a>");
        out.println("    </header>");
        out.println("    <aside>");
        out.println("        <form action=\"create-servlet\" method=\"post\">");
        out.println("            <label for=\"client_id\">ID клиента: </label>");
        out.println("            <br>");
        out.println("            <input type=\"text\" name=\"client_id\" value=\"1\" readonly>");
        out.println("            <br><br>");
        out.println("            <label>Введите ФИО клиента</label>");
        out.println("            <br>");
        out.println("            <input type=\"text\" name=\"client_name\" placeholder=\"Введите ФИО клиента\">");
        out.println("            <br><br>");
        out.println("            <label>Выбор типа клиента</label>");
        out.println("            <br>");
        out.println("            <select name=\"type\">");
        out.println("                <option value=\"Юридическое лицо\">Юридическое лицо</option>");
        out.println("                <option value=\"Физическое лицо\">Физическое лицо</option>");
        out.println("            </select>");
        out.println("            <br><br>");
        out.println("            <label>Дата добавления клиента</label>");
        out.println("            <input type=\"date\" name=\"added\">");
        out.println("            <br><br>");
        out.println("            <button type=\"submit\" formmethod=\"post\">ЗАРЕГИСТРИРОВАТЬ</button>");
        out.println("        </form>");
        out.println("    </aside>");
        out.println("    <main>");
        out.println("        <h1>Список клиентов:</h1>");
        // Формирование данных о клиенах
        out.println(report(request, response));
        out.println("    </main>");
        out.println("    <footer></footer>");
        out.println("</body>");
        out.println("</html>");
    }
    private String report(HttpServletRequest request, HttpServletResponse response){
        StringBuilder report = new StringBuilder();
        String client_id = request.getParameter("client_id");
        String client_name = request.getParameter("client_name");
        String type = request.getParameter("type");
        String date = request.getParameter("added");
        report.append("        <p>"+ "" +"</p>"); 
        report.append("        <p>"+ "" +"</p>");
        report.append("        <p>"+ "" +"</p>");
        report.append("        <p>"+ "дата" +"</p>");
        return report.toString();
    }
}
