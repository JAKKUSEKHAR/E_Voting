package com.evoting.dao;

import java.util.List;
import com.evoting.dto.Election;

public interface ElectionDAO {

    boolean createElection(Election e);

    List<Election> getAllElections();

    List<Election> getActiveElections();

    Election getElectionById(int electionId);
    
    boolean closeElection(int electionId);

}
