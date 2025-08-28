package com.community.blood.dao;

import com.community.blood.model.User;
import com.community.blood.util.DBUtil;

import java.sql.*;

public class UserDAO {

    public boolean emailExists(String email) throws SQLException {
        String sql = "SELECT id FROM users WHERE email=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    public void save(User u) throws SQLException {
        String sql = "INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getRole());
            ps.executeUpdate();
        }
    }

    public User authenticate(String email, String password) throws SQLException {
        String sql = "SELECT id,name,email,role FROM users WHERE email=? AND password=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setRole(rs.getString("role"));
                return u;
            }
        }
        return null;
    }
}
