package ru.molokoin.j200.servlets;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.molokoin.j200.entities.Address;
import ru.molokoin.j200.entities.Client;
import ru.molokoin.j200.services.RepositoryFace;

@WebServlet(name = "UpdateAddress", value = "/update-address")
public class UpdateAddress extends HttpServlet{
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
        Address address = repository.getAddressById(Integer.parseInt((String)request.getParameter("addressid")));
        address.setIp(request.getParameter("ip"));
        address.setMac(request.getParameter("mac"));
        address.setModel(request.getParameter("model"));
        address.setAddress(request.getParameter("address"));
        repository.updateAddress(address);
        response.sendRedirect("create-client?clientid=" + address.getClient().getId());
    }
    
}
