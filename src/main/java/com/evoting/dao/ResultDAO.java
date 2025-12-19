package com.evoting.dao;

import java.util.List;
import com.evoting.dto.ElectionResult;

public interface ResultDAO {

    List<ElectionResult> getResultsByElection(int electionId);

}
