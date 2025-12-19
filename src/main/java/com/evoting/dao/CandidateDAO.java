package com.evoting.dao;

import java.util.List;
import com.evoting.dto.Candidate;

public interface CandidateDAO {

    boolean addCandidate(Candidate c);

    List<Candidate> getCandidatesByElection(int electionId);
}

