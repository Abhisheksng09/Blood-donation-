package com.community.blood.controller;

import com.community.blood.dao.BloodRequestDAO;
import com.community.blood.model.BloodRequest;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="ListRequestsServlet", value="/requests")
public class ListRequestsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<BloodRequest> list = new BloodRequestDAO().listOpen();
            req.setAttribute("requests", list);
            req.getRequestDispatcher("requests.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
