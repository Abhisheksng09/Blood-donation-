package com.community.blood.controller;

import com.community.blood.dao.BloodRequestDAO;
import com.community.blood.model.BloodRequest;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="OpenRequestServlet", value="/open-requests")
public class OpenRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BloodRequestDAO requestDAO = new BloodRequestDAO();
            List<BloodRequest> openRequests = requestDAO.listOpen();   // DAO call
            req.setAttribute("requests", openRequests);

            // Forward to JSP
            req.getRequestDispatcher("open-requests.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException("Error fetching open requests", e);
        }
    }
}
