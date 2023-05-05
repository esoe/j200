package ru.molokoin.j200;

import ru.molokoin.j200.model.Passport;
import ru.molokoin.j200.model.Person;
import ru.molokoin.j200.services.PersonService;
import ru.molokoin.j200.services.PersonServiceImpl;
import jakarta.ejb.EJB;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "ServletViewList", value = "/ServletViewList")
public class ServletViewList extends HttpServlet {

    @EJB
    private PersonService personService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendHtml(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendHtml(request, response);
    }

    private void sendHtml(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body align=\"center\">");
        out.println("<h1>" + "Все персоны" + "</h1>");
        out.println("<table align=\"center\" border=\"1\" cellpadding=\"5\">");
        out.println("<tr>");
        out.println("<td>ID</td>");
        out.println("<td>Name</td>");
        out.println("<td>serial</td>");
        out.println("<td>number</td>");
        out.println("</tr>");

        Set<Person> persons = personService.getAllPerson();
        for(Person person : persons) {
            Set<Passport> passports = person.getPassports();
            if(passports!=null && !passports.isEmpty()) {
                for(Passport passport : passports) {
                    out.println("<tr>");
                    out.println("<td>" + person.getId() + "</td>");
                    out.println("<td>" + person.getName() + "</td>");
                    out.println("<td>" + passport.getSerial() + "</td>");
                    out.println("<td>" + passport.getNumber() + "</td>");
                    out.println("</tr>");
                }
            }else {
                out.println("<tr>");
                out.println("<td>" + person.getId() + "</td>");
                out.println("<td>" + person.getName() + "</td>");
                out.println("<td></td>");
                out.println("<td></td>");
                out.println("</tr>");
            }
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
