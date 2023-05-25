package ru.molokoin.j200.servlets;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.entities.Client;
import ru.molokoin.j200.services.RepositoryFace;

@WebServlet(name = "RemoveClient", value = "/remove-client")
public class RemoveClient extends HttpServlet{
    @EJB
    private RepositoryFace repository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Integer id = Integer.parseInt((String)request.getParameter("clientid"));
        
        repository.removeClient(id);
        response.sendRedirect("view-list");
    }
    
}
