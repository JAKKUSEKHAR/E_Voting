package com.evoting.dao;

public interface VoteDAO {

    boolean hasVoted(int electionId, String voterToken);

    boolean castVote(int electionId, String voterToken, int candidateId);
}
