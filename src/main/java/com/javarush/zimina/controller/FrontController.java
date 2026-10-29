package com.javarush.zimina.controller;


import com.javarush.zimina.cmd.Command;
import com.javarush.zimina.config.Container;
import com.javarush.zimina.util.Go;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({Go.INDEX, Go.HOME, Go.SIGNUP, Go.LOGIN, Go.LOGOUT, Go.PROFILE})
public class FrontController extends HttpServlet {

    private final HttpResolver httpResolver = Container.find(HttpResolver.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = httpResolver.resolve(req);
        String view = command.doGet(req);
        String jsp = "/WEB-INF/" + view + ".jsp";
        req.getRequestDispatcher(jsp).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Command command = httpResolver.resolve(req);
        String redirect = command.doPost(req);
        resp.sendRedirect(redirect);
    }
}
