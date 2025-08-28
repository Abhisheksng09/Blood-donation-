package com.community.blood.controller;

import com.community.blood.dao.UserDAO;
import com.community.blood.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="LoginServlet", value="/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            UserDAO dao = new UserDAO();
            User user = dao.authenticate(email, password);
            if (user == null) {
                req.setAttribute("error", "Invalid credentials");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                return;
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            resp.sendRedirect("dashboard.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
