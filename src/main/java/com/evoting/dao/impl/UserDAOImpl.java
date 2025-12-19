package com.evoting.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.evoting.dao.UserDAO;
import com.evoting.dto.User;
import com.evoting.util.DBConnection;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean registerUser(User u) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(username, email, phone, password, role, is_approved) VALUES(?,?,?,?,?,?)"
            );

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPhone());
            ps.setString(4, u.getPassword());
            ps.setString(5, "VOTER");
            ps.setBoolean(6, false);

            if( ps.executeUpdate() == 1)
            	{
            	return true;
            	}

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    @Override
    public User login(String email, String password) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?"
            );

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getString("phone"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
                u.setApproved(rs.getBoolean("is_approved"));
                u.setVoterToken(rs.getString("voter_token"));
                System.out.println("Voter token is ===>>"+rs.getString("voter_token"));
                return u;
            }

        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    @Override
    public List<User> getPendingUsers() {
        List<User> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE role='VOTER' AND is_approved=FALSE"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                list.add(u);
            }

        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }

    @Override
    public boolean approveUser(int userId, String token) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE users SET is_approved=TRUE, voter_token=? WHERE user_id=?"
            );

            ps.setString(1, token);
            ps.setInt(2, userId);

            return ps.executeUpdate() == 1;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }
}

