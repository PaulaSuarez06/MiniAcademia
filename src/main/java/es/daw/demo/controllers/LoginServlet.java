package es.daw.demo.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");


    if(!email.equals("paula@paula.com") || !password.equals("paula123")){
        request.setAttribute("error", "Credenciales incorrectas");
    }else {
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("email")){
                response.addCookie(cookie);
            }
        }
    }



    }
}
