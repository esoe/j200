package ru.molokoin.j200.servlets;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.services.RepositoryFace;

@WebServlet(name = "AddAddress", value = "/add-address")
public class AddAddress extends HttpServlet{
    @EJB
    private RepositoryFace repository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Integer id = Integer.parseInt((String)request.getParameter("id"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Integer id = Integer.parseInt((String)request.getParameter("id"));
        
        /**
         * Подготовить параметры, чтобы после добавления адреса, вернуть пользователя на страницу редактирования клиента, с которой он ушел
         */
        response.sendRedirect("create-client?id=" + id);
    }
}