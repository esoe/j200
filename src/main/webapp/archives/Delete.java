package ru.molokoin.j200.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "Delete", value = "/delete")
public class Delete extends HttpServlet{
    @Override
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

        //header
        out.println("    <header>");
        out.println("        <a href=\"content/Лабораторная_работа_по_курсу_DEV_J200.pdf\">");
        out.println("            <h1>J200 : разработка корпоративных приложений</h1>");
        out.println("        </a>");
        out.println("    </header>");

        //aside
        out.println("    <aside>");
        out.println("    </aside>");

        //main
        out.println("    <main>");
        out.println("       DELETE : SERVLETE");
        out.println("    </main>");
        
        //footer
        out.println("    <footer></footer>");
        out.println("</body>");
        out.println("</html>");
    }
    
}
