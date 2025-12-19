package com.evoting.dao.impl;

import java.sql.*;
import java.util.*;

import com.evoting.dao.ElectionDAO;
import com.evoting.dto.Election;
import com.evoting.util.DBConnection;

public class ElectionDAOImpl implements ElectionDAO {

    @Override
    public boolean createElection(Election e) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO elections(title, type, description, start_date, end_date, status, created_by) VALUES(?,?,?,?,?,?,?)"
            );

            ps.setString(1, e.getTitle());
            ps.setString(2, e.getType());
            ps.setString(3, e.getDescription());
            ps.setTimestamp(4, e.getStartDate());
            ps.setTimestamp(5, e.getEndDate());
            ps.setString(6, "RUNNING");
            ps.setInt(7, e.getCreatedBy());

            return ps.executeUpdate() == 1;

        } catch (Exception ex) { ex.printStackTrace(); }

        return false;
    }

    @Override
    public List<Election> getAllElections() {
        List<Election> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM elections");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	Election e = new Election();
            	e.setElectionId(rs.getInt("election_id"));
            	e.setTitle(rs.getString("title"));
            	e.setType(rs.getString("type"));
            	e.setDescription(rs.getString("description"));
            	e.setStartDate(rs.getTimestamp("start_date"));
            	e.setEndDate(rs.getTimestamp("end_date"));
            	e.setStatus(rs.getString("status"));
            	  list.add(e); 
            }

        } catch (Exception ex) { ex.printStackTrace(); }

        return list;
    }

    @Override
    public List<Election> getActiveElections() {
        List<Election> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM elections WHERE status='RUNNING'"
            );

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Election e = new Election();
                e.setElectionId(rs.getInt("election_id"));
                e.setTitle(rs.getString("title"));
                list.add(e);
            }

        } catch (Exception ex) { ex.printStackTrace(); }

        return list;
    }

    @Override
    public Election getElectionById(int electionId) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM elections WHERE election_id=?"
            );

            ps.setInt(1, electionId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Election e = new Election();
                e.setElectionId(rs.getInt("election_id"));
                e.setTitle(rs.getString("title"));
                e.setDescription(rs.getString("description"));
                return e;
            }

        } catch (Exception ex) { ex.printStackTrace(); }

        return null;
    }
    
    @Override
    public boolean closeElection(int electionId) {
        try {
            Connection con = DBConnection.getConnection();

            System.out.println("DAO closing election ID: " + electionId);

            PreparedStatement ps = con.prepareStatement(
                "UPDATE elections SET status=? WHERE election_id=?"
            );
            ps.setString(1, "CLOSED");
            ps.setInt(2, electionId);
System.out.println(electionId + " printing election id while at the time of closing the election");
            int rows = ps.executeUpdate();
            System.out.println("Rows updated: " + rows);

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
