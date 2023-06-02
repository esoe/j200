package ru.molokoin.j200.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.entities.Client;
import ru.molokoin.j200.services.RepositoryFace;

@WebServlet(name = "UpdateClient", value = "/update-client")
public class UpdateClient extends HttpServlet{
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
        Client client = repository.getClientById(Integer.parseInt((String)request.getParameter("id")));
        client.setName(request.getParameter("name"));
        client.setClient_type(request.getParameter("client_type"));
        client.setAdded(request.getParameter("added"));
        repository.updateClient(client);
        response.sendRedirect("view-list");
    }
    
}
