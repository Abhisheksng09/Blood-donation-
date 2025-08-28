package com.community.blood.controller;

import com.community.blood.dao.DonorDAO;
import com.community.blood.model.Donor;
import com.community.blood.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name="BecomeDonorServlet", value="/become-donor")
public class BecomeDonorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }
        User user = (User) session.getAttribute("user");
        String bloodGroup = req.getParameter("bloodGroup");
        String city = req.getParameter("city");
        String phone = req.getParameter("phone");
        try {
            Donor d = new Donor();
            d.setUserId(user.getId());
            d.setBloodGroup(bloodGroup);
            d.setCity(city);
            d.setPhone(phone);
            new DonorDAO().save(d);
            resp.sendRedirect("dashboard.jsp?donor=1");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
