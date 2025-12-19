package com.evoting.dao.impl;

import java.sql.*;
import java.util.*;

import com.evoting.dao.ResultDAO;
import com.evoting.dto.ElectionResult;
import com.evoting.util.DBConnection;

public class ResultDAOImpl implements ResultDAO {

    @Override
    public List<ElectionResult> getResultsByElection(int electionId) {

        List<ElectionResult> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "SELECT c.candidate_id, c.name, COUNT(v.vote_id) AS votes " +
                "FROM candidates c " +
                "LEFT JOIN votes v ON c.candidate_id = v.candidate_id " +
                "WHERE c.election_id = ? " +
                "GROUP BY c.candidate_id, c.name " +
                "ORDER BY votes DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, electionId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ElectionResult r = new ElectionResult();
                r.setCandidateId(rs.getInt("candidate_id"));
                r.setCandidateName(rs.getString("name"));
                r.setVoteCount(rs.getInt("votes"));
                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
