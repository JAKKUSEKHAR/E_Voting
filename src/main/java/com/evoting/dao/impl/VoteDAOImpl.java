package com.evoting.dao.impl;

import java.sql.*;

import com.evoting.dao.VoteDAO;
import com.evoting.util.DBConnection;

public class VoteDAOImpl implements VoteDAO {

    @Override
    public boolean hasVoted(int electionId, String voterToken) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT COUNT(*) FROM votes WHERE election_id=? AND voter_token=?"
            );
            ps.setInt(1, electionId);
            ps.setString(2, voterToken);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }

    @Override
    public boolean castVote(int electionId, String voterToken, int candidateId) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO votes(election_id, voter_token, candidate_id) VALUES(?,?,?)"
            );

            ps.setInt(1, electionId);
            ps.setString(2, voterToken);
            ps.setInt(3, candidateId);

            return ps.executeUpdate() == 1;

        } catch (Exception e) { e.printStackTrace(); }

        return false;
    }
}
