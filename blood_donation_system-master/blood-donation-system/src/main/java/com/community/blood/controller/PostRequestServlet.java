package com.community.blood.controller;

import com.community.blood.dao.BloodRequestDAO;
import com.community.blood.dao.DonorDAO;
import com.community.blood.model.BloodRequest;
import com.community.blood.model.Donor;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="PostRequestServlet", value="/post-request")
public class PostRequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String patientName = req.getParameter("patientName");
        String bloodGroup = req.getParameter("bloodGroup");
        String city = req.getParameter("city");
        String hospital = req.getParameter("hospital");
        String contact = req.getParameter("contact");

        try {
            BloodRequest r = new BloodRequest();
            r.setPatientName(patientName);
            r.setBloodGroup(bloodGroup);
            r.setCity(city);
            r.setHospital(hospital);
            r.setContact(contact);
            new BloodRequestDAO().save(r);

            // Find matching donors
            List<Donor> matches = new DonorDAO().findMatching(bloodGroup, city);
            req.setAttribute("matches", matches);
            req.setAttribute("success", "Request posted successfully!");
            req.getRequestDispatcher("requests.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
