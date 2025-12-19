package com.evoting.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.evoting.dao.CandidateDAO;
import com.evoting.dto.Candidate;
import com.evoting.util.DBConnection;

public class CandidateDAOImpl implements CandidateDAO {

    @Override
    public boolean addCandidate(Candidate c) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO candidates(election_id, name, details) VALUES(?,?,?)"
            );

            ps.setInt(1, c.getElectionId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getDetails());

            return ps.executeUpdate() == 1;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }

    @Override
    public List<Candidate> getCandidatesByElection(int electionId) {
        List<Candidate> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM candidates WHERE election_id=?"
            );

            ps.setInt(1, electionId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Candidate c = new Candidate();
                c.setCandidateId(rs.getInt("candidate_id"));
                c.setElectionId(rs.getInt("election_id"));
                c.setName(rs.getString("name"));
                c.setDetails(rs.getString("details"));
                list.add(c);
            }

        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }
}
