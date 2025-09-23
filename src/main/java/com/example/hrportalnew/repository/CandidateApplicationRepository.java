package com.finalproject.hrportal.repository;

import java.util.List;

public interface CandidateApplicationRepository {
    List<Integer> getCandidateIdsBasedOnJobRequestId(int jobRequestId);
    boolean changeStatusOfCandidateToShortListed(int jobRequestId, int candidateId,String status);
}
