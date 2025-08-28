package com.community.blood.controller;

import com.community.blood.dao.UserDAO;
import com.community.blood.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="RegisterServlet", value="/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        try {
            UserDAO dao = new UserDAO();
            if (dao.emailExists(email)) {
                req.setAttribute("error", "Email already registered");
                req.getRequestDispatcher("register.jsp").forward(req, resp);
                return;
            }
            User u = new User();
            u.setName(name);
            u.setEmail(email);
            u.setPassword(password); // NOTE: For demo only. Hash in real apps.
            u.setRole("USER");
            dao.save(u);
            resp.sendRedirect("login.jsp?registered=1");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
