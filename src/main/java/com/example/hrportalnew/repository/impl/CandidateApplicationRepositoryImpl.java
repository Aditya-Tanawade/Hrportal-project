package com.finalproject.hrportal.repository.impl;

import com.finalproject.hrportal.domain.enums.CandidateApplicationStatus;
import com.finalproject.hrportal.exceptions.ResourceNotFoundException;
import com.finalproject.hrportal.repository.CandidateApplicationRepository;
import com.finalproject.hrportal.rowmapper.CandidateApplicationRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class CandidateApplicationRepositoryImpl implements CandidateApplicationRepository {

    private final JdbcTemplate jdbcTemplate;

    public List<Integer> getCandidateIdsBasedOnJobRequestId(int jobRequestId){
        String sql="Select candidate_id From candidate_applications WHERE job_request_id=?";
        List<Integer>candidatesIds=jdbcTemplate.query(sql, (rs, rowNum) -> rs.getInt("candidate_id"),jobRequestId);
        if(candidatesIds.size()==0){
            throw (new ResourceNotFoundException("NO Candidates APPLIED FOR This Jobs " ));
        }
        return candidatesIds;
    }

    @Override
    public boolean changeStatusOfCandidateToShortListed(int jobRequestId, int candidateId,String status) {
        String sql="UPDATE candidate_applications SET status=? WHERE job_request_id=? AND candidate_id=? ";
        return jdbcTemplate.update(sql, CandidateApplicationStatus.valueOf(status).toString(),jobRequestId,candidateId)>0;
    }


}
