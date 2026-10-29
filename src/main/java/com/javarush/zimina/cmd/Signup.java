package com.javarush.zimina.cmd;

import com.javarush.zimina.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

public class Signup implements Command{
    private final UserService userService;

    public Signup(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String doPost(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(userService.register(login, password)){
            return "home";
        }
        return "signup?error=taken";
    }
}
