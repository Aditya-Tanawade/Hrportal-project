package com.finalproject.hrportal.rowmapper;

import com.finalproject.hrportal.domain.CandidateApplication;
import com.finalproject.hrportal.domain.Employee;
import com.finalproject.hrportal.domain.enums.CandidateApplicationStatus;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class CandidateApplicationRowMapper implements RowMapper<CandidateApplication> {
    @Override
    public CandidateApplication mapRow(ResultSet rs, int rowNum) throws SQLException {
        int applicationId=rs.getInt("APPLICATION_ID");
        int candidateId=rs.getInt("CANDIDATE_ID");
        int jobRequestId=rs.getInt("JOB_REQUEST_ID");
        LocalDate appliedAt=rs.getDate("APPLIED_AT").toLocalDate();
        CandidateApplicationStatus status=CandidateApplicationStatus.valueOf(rs.getString("STATUS"));
        LocalDate createdAt=rs.getDate("CREATED_AT").toLocalDate();
        LocalDate updatedAt=rs.getDate("UPDATED_AT").toLocalDate();
        return new CandidateApplication(applicationId,candidateId,jobRequestId,appliedAt,status,createdAt,updatedAt);
    }
}
