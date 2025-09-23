package com.finalproject.hrportal.repository;

import com.finalproject.hrportal.domain.Candidate;
import com.finalproject.hrportal.dto.CandidateFilterRequestDTO;

import java.util.List;

public interface CandidateRepository {
    List<Candidate> searchCandidates(int jobRequestId,CandidateFilterRequestDTO filter);
    Candidate getCandidateById(int candidateId);
}
