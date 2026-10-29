package com.javarush.zimina.cmd;

import com.javarush.zimina.entity.User;
import com.javarush.zimina.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

public class Login implements Command {
    private final UserService userService;

    public Login(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String doPost(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.login(login, password);
        if (user == null) {
            return "login?error=wrong";
        }
        request.getSession().setAttribute("user", user);
        return "home";
    }
}
