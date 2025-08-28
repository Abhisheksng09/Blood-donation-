package com.community.blood.dao;

import com.community.blood.model.BloodRequest;
import com.community.blood.util.DBUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BloodRequestDAO {

    public void save(BloodRequest r) throws SQLException {
        String sql = "INSERT INTO blood_requests(patient_name,blood_group,city,hospital,contact,status,created_at) VALUES(?,?,?,?,?,'OPEN',NOW())";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, r.getPatientName());
            ps.setString(2, r.getBloodGroup());
            ps.setString(3, r.getCity());
            ps.setString(4, r.getHospital());
            ps.setString(5, r.getContact());
            ps.executeUpdate();
        }
    }

    public List<BloodRequest> listOpen() throws SQLException {
        String sql = "SELECT id,patient_name,blood_group,city,hospital,contact,status,created_at FROM blood_requests WHERE status='OPEN' ORDER BY created_at DESC";
        List<BloodRequest> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BloodRequest br = new BloodRequest();
                br.setId(rs.getInt("id"));
                br.setPatientName(rs.getString("patient_name"));
                br.setBloodGroup(rs.getString("blood_group"));
                br.setCity(rs.getString("city"));
                br.setHospital(rs.getString("hospital"));
                br.setContact(rs.getString("contact"));
                br.setStatus(rs.getString("status"));
                Timestamp ts = rs.getTimestamp("created_at");
                br.setCreatedAt(ts != null ? ts.toLocalDateTime() : LocalDateTime.now());
                list.add(br);
            }
        }
        return list;
    }
}
