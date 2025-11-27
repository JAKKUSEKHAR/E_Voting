package com.evoting.dto;

public class Vote {
    private int voteId;
    private int electionId;
    private String voterToken;
    private int candidateId;

    public int getVoteId() { return voteId; }
    public void setVoteId(int voteId) { this.voteId = voteId; }

    public int getElectionId() { return electionId; }
    public void setElectionId(int electionId) { this.electionId = electionId; }

    public String getVoterToken() { return voterToken; }
    public void setVoterToken(String voterToken) { this.voterToken = voterToken; }

    public int getCandidateId() { return candidateId; }
    public void setCandidateId(int candidateId) { this.candidateId = candidateId; }
}
