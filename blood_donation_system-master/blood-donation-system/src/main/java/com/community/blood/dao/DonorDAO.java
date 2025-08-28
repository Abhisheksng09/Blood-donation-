package com.community.blood.dao;

import com.community.blood.model.Donor;
import com.community.blood.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DonorDAO {

    public void save(Donor d) throws SQLException {
        String sql = "INSERT INTO donors(user_id,blood_group,city,phone) VALUES(?,?,?,?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getUserId());
            ps.setString(2, d.getBloodGroup());
            ps.setString(3, d.getCity());
            ps.setString(4, d.getPhone());
            ps.executeUpdate();
        }
    }

    public List<Donor> findMatching(String bloodGroup, String city) throws SQLException {
        String sql = "SELECT id,user_id,blood_group,city,phone FROM donors WHERE blood_group=? AND city=?";
        List<Donor> list = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bloodGroup);
            ps.setString(2, city);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Donor d = new Donor();
                d.setId(rs.getInt("id"));
                d.setUserId(rs.getInt("user_id"));
                d.setBloodGroup(rs.getString("blood_group"));
                d.setCity(rs.getString("city"));
                d.setPhone(rs.getString("phone"));
                list.add(d);
            }
        }
        return list;
    }
}
